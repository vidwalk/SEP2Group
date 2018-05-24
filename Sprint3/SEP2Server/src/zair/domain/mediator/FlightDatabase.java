package zair.domain.mediator;

import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import utility.persistence.MyDatabase;
import zair.domain.model.Date;
import zair.domain.model.Flight;
import zair.domain.model.FlightList;
import zair.domain.model.Log;
import zair.domain.model.Ticket;

public class FlightDatabase implements FlightTarget {
	private Connection c;
	private Statement stmt;

	///////////////////////////////// DB
	///////////////////////////////// SETUP///////////////////////////////////////////////

	public FlightDatabase(String password, String databaseName) {

		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + databaseName, "postgres", password);
			c.setAutoCommit(true);
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			System.out.println("Database query ok ");
		}
	}

	public void save(Flight flight) {
		try {
			stmt = c.createStatement();
			String dateOfArrival = flight.getDateArrival().toString();
			String dateOfDeparture = flight.getDateDeparture().toString();
			String origin = "" + flight.getOrigin().getInitials();
			String destination = "" + flight.getDestination().getInitials();
			String timeDeparture = flight.getTimeDeparture().toString();
			String timeArrival = flight.getTimeArrival().toString();
			String price = "" + flight.getPrice();
			String numberOfTickets = "" + 20;
			String numberOfTicketsLeft = "" + flight.getNumberOfTicketsLeft();
			String flightID = flight.getId().toString().substring(15);
			stmt = c.createStatement();
			String selectSQL = "INSERT INTO zair.\"Flight\" " + "VALUES ('" + flightID + "', '" + origin + "', '"
					+ destination + "', '" + dateOfArrival + "', '" + dateOfDeparture + "', '" + timeDeparture + "', '"
					+ timeArrival + "', " + numberOfTickets + ", " + numberOfTicketsLeft + ", " + price + ");";
			stmt.executeUpdate(selectSQL);
		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	@Override
	public void remove(int index) {
		try {
			stmt = c.createStatement();
			stmt.executeUpdate("DELETE FROM zair.\"Flight\"\r\n" + "	WHERE \"flightID\" =" + index + ";");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

	}

	private Date StringToDate(String string) {
		int year = Integer.parseInt(string.substring(0, 4));
		int day = Integer.parseInt(string.substring(5, 7));
		int month = Integer.parseInt(string.substring(8, 10));

		Date date = new Date(day, month, year);
		return date;
	}

	@Override
	public FlightList loadAll() {
		FlightList fl = null;
		try {
			stmt = c.createStatement();
			String selectSQL = "SELECT COUNT(*) AS total FROM zair.\"Flight\";";
			PreparedStatement preparedStatement;
			preparedStatement = c.prepareStatement(selectSQL);
			ResultSet resultSet1 = preparedStatement.executeQuery();
			resultSet1.next();
			int amount = resultSet1.getInt(1);
			// int amount =resultSet1.getInt("total");
			fl = new FlightList();

			int i = 0;
			preparedStatement = c.prepareStatement("SELECT *\r\n" + "FROM zair.\"Flight\";");
			resultSet1 = preparedStatement.executeQuery();
			while (resultSet1.next()) {

				Date dateDeparture = StringToDate(resultSet1.getString("dateOfDeparture"));
				Date dateArrival = StringToDate(resultSet1.getString("dateOfArrival"));
				String origin = resultSet1.getString("origin");
				String destination = resultSet1.getString("destination");
				String timeDeparture = resultSet1.getString("timeOfDeparture");
				String timeArrival = resultSet1.getString("timeOfArrival");
				double price = resultSet1.getDouble("price");

				fl.addFlight(new Flight(dateDeparture, dateArrival, origin, destination, timeDeparture, timeArrival, price));
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

		return fl;

	}

	@Override
	public Flight load(String id) {

		Flight fl = null;
		try {
			stmt = c.createStatement();

			String selectSQL = "SELECT * FROM Flight WHERE flightID = ?";
			PreparedStatement preparedStatement;
			preparedStatement = c.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);
			ResultSet resultSet1 = preparedStatement.executeQuery();

			while (resultSet1.next()) {

				Date dateDeparture = StringToDate(resultSet1.getString("dateOfDeparture"));
				Date dateArrival = StringToDate(resultSet1.getString("dateOfArrival"));
				String origin = resultSet1.getString("origin");
				String destination = resultSet1.getString("destination");
				String timeDeparture = resultSet1.getString("timeOfDeparture");
				String timeArrival = resultSet1.getString("timeOfArrival");
				double price = resultSet1.getDouble("price");

				fl = new Flight(dateArrival, dateDeparture, origin, destination, timeDeparture, timeArrival, price);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return fl;
	}

	@Override
	public void clearAll(String tableName) // table = "Flight" / "Ticket" / "Customer" / "CustomerCredentials" or
											// whatever
	{
			try
         {
            stmt = c.createStatement();
            stmt.executeUpdate("DELETE FROM zair.\"" + tableName + "\"\r\n");
         }
         catch (SQLException e)
         {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
	}

	public void closeDatabase() {
		try {
			stmt.close();
			c.close();
		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

}
