package zair.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utility.persistence.MyDatabase;
import zair.domain.model.Credentials;
import zair.domain.model.Customer;
import zair.domain.model.Date;
import zair.domain.model.Flight;

public class FlightDatabase implements FlightTarget {
	private Connection c = null;
	private Statement stmt = null;
	private MyDatabase database;

	///////////////////////////////// DB
	///////////////////////////////// SETUP///////////////////////////////////////////////

	public FlightDatabase(String password) {
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", password);
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			System.out.println("Database query ok ");
		}
	}

	public void addFlight(Flight flight) {
		try {
			stmt = c.createStatement();
			String dateOfArrival = flight.getDateArrival().toString();
			String dateOfDeparture = flight.getDateDeparture().toString();
			String origin = "" + flight.getOrigin().getInitials();
			String destination = "" + flight.getDestination().getInitials();
			String timeDeparture = flight.getTimeDeparture().toString();
			String timeArrival = flight.getTimeArrival().toString();
			String price = "" + flight.getPrice();
			String numberOfTickets = "" + 50;
			String numberOfTicketsLeft = "" + flight.getNumberOfTicketsLeft();
			String flightID = flight.getId().toString().substring(15);

			System.out.println("INSERT INTO zair.\"Flight\" " + "VALUES ('" + flightID + "', '" + origin + "', '"
					+ destination + "', '" + dateOfArrival + "', '" + dateOfDeparture + "', '" + timeDeparture + "', '"
					+ timeArrival + "', " + numberOfTickets + ", " + numberOfTicketsLeft + ", " + price + ");");

			stmt.executeUpdate("INSERT INTO zair.\"Flight\" " + "VALUES ('" + flightID + "', '" + origin + "', '"
					+ destination + "', '" + dateOfArrival + "', '" + dateOfDeparture + "', '" + timeDeparture + "', '"
					+ timeArrival + "', " + numberOfTickets + ", " + numberOfTicketsLeft + ", " + price + ");");

		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			System.out.println("Database query ok ");
		}
	}

	@Override
	public void removeFlight(int index) {
		try {
			stmt = c.createStatement();
			stmt.executeUpdate("DELETE FROM Flight WHERE index =" + index + "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Flight[] getTodayFlights() {

		Date date = new Date(); // it will create todays date
		Flight[] fl = null;
		try {
			stmt = c.createStatement();
			String selectSQL = "SELECT COUNT(*) AS total FROM Flight WHERE dateOfDeparture = ? ";
			PreparedStatement preparedStatement = c.prepareStatement(selectSQL);
			preparedStatement.setString(1, date.toString());
			ResultSet resultSet = preparedStatement.executeQuery();
			int amount = resultSet.getInt("total");

			String selectSQL1 = "SELECT * FROM Flight WHERE dateOfDeparture = ? ";
			PreparedStatement preparedStatement1 = c.prepareStatement(selectSQL1);
			preparedStatement.setString(1, date.toString());
			ResultSet resultSet1 = preparedStatement1.executeQuery();

			fl = new Flight[amount];
			int i = 0;

			while (resultSet.next()) {

				Date dateDeparture = StringToDate(resultSet1.getString("dateOfDeparture"));
				Date dateArrival = StringToDate(resultSet1.getString("dateOfArrival"));
				String origin = resultSet1.getString("origin");
				String destination = resultSet1.getString("destination");
				String timeDeparture = resultSet1.getString("timeOfDeparture");
				String timeArrival = resultSet1.getString("timeOfArrival");
				double price = resultSet1.getDouble("price");
				int numberOfTicketsLeft = resultSet1.getInt("nrOfTicketsLeft");
				int nrOfTickets = resultSet1.getInt("nrOfTickets");

				fl[i] = new Flight(dateDeparture, dateArrival, origin, destination, timeDeparture, timeArrival, price);

				i++;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fl;
	}

	private Date StringToDate(String string) {
		int day = Integer.parseInt(string.substring(0, 2));
		int month = Integer.parseInt(string.substring(3, 5));
		int year = Integer.parseInt(string.substring(6, 10));

		Date date = new Date(day, month, year);
		return date;
	}

	@Override
	public Flight[] getAllFlights() {
		Flight[] fl = null;
		try {
			stmt = c.createStatement();
			String selectSQL = "SELECT COUNT(*) AS total FROM Flight";
			PreparedStatement preparedStatement;
			preparedStatement = c.prepareStatement(selectSQL);
			ResultSet resultSet1 = preparedStatement.executeQuery();

			int amount = resultSet1.getInt("total");
			fl = new Flight[amount];

			int i = 0;
			while (resultSet1.next()) {

				Date dateDeparture = StringToDate(resultSet1.getString("dateOfDeparture"));
				Date dateArrival = StringToDate(resultSet1.getString("dateOfArrival"));
				String origin = resultSet1.getString("origin");
				String destination = resultSet1.getString("destination");
				String timeDeparture = resultSet1.getString("timeOfDeparture");
				String timeArrival = resultSet1.getString("timeOfArrival");
				double price = resultSet1.getDouble("price");
				int numberOfTicketsLeft = resultSet1.getInt("nrOfTicketsLeft");
				int nrOfTickets = resultSet1.getInt("nrOfTickets");

				fl[i] = new Flight(dateDeparture, dateArrival, origin, destination, timeDeparture, timeArrival, price);
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fl;

	}

	@Override
	public Flight getFlight(String id) {

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
				int numberOfTicketsLeft = resultSet1.getInt("nrOfTicketsLeft");
				int nrOfTickets = resultSet1.getInt("nrOfTickets");

				fl = new Flight(dateDeparture, dateArrival, origin, destination, timeDeparture, timeArrival, price);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fl;
	}

	@Override
	public void addCustomer(Customer customer) {
		try {
			stmt = c.createStatement();
			String customerID = customer.getCustomerNo();
			String fname = customer.getFname();
			String lname = customer.getLname();
			String email = customer.getEmail();
			String phone = customer.getPhone();
			String passportNo = customer.getPassportNo();
			String userID = customer.getCredentials().getUserId();
			String password = customer.getCredentials().getPassword();
			System.out.println("INSERT INTO zair.\"Customer\" " + "VALUES ('" + customerID + "', '" + fname + "', '"
					+ lname + "', '" + email + "', '" + passportNo + "', '" + phone + ");");

			stmt.executeUpdate("INSERT INTO zair.\"Customer\" " + "VALUES ('" + customerID + "', '" + fname + "', '"
					+ lname + "', '" + email + "', '" + passportNo + "', '" + phone + ");");
			stmt = c.createStatement();
			System.out.println(
					"INSERT INTO zair.\"CustomerCredentials\" " + "VALUES ('" + userID + "', '" + password + ");");
			stmt.executeUpdate(
					"INSERT INTO zair.\"CustomerCredentials\" " + "VALUES ('" + userID + "', '" + password + ");");

		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			System.out.println("Database query ok ");
		}
	}

	@Override
	public Customer getCustomer(String id) {
		Customer customer = null;
		try {
			stmt = c.createStatement();
			String selectSQL = "SELECT * FROM zair.\"Customer\" WHERE \"customerID\" = " + id + ";";
			PreparedStatement preparedStatement;
			preparedStatement = c.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);
			ResultSet resultSet1 = preparedStatement.executeQuery();

			while (resultSet1.next()) {

				String customerID = resultSet1.getString("customerID");
				String fname = resultSet1.getString("fName");
				String lname = resultSet1.getString("lName");
				String email = resultSet1.getString("email");
				String passportNo = resultSet1.getString("passportNo");
				String phone = resultSet1.getString("phone");

				customer = new Customer(fname, lname, email, phone, passportNo, "", "");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public Credentials getCustomerCredentials(String id) {
		Credentials credentials= null;
		try {
			stmt = c.createStatement();
			String selectSQL = "SELECT * FROM zair.\"CustomerCredentials\" WHERE \"customerID\" = " + id + ";";
			PreparedStatement preparedStatement;
			preparedStatement = c.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);
			ResultSet resultSet1 = preparedStatement.executeQuery();

			while (resultSet1.next()) {

				String customerID = resultSet1.getString("customerID");
				String password = resultSet1.getString("password");

				credentials = new Credentials(customerID, password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return credentials;
	}

}
