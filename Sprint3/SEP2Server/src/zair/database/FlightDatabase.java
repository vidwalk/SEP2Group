package zair.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utility.persistence.MyDatabase;
import zair.domain.model.Date;
import zair.domain.model.Flight;

public class FlightDatabase implements FlightTarget
{
   private Connection c = null;
   private Statement stmt = null;
   private MyDatabase database;

   ///////////////////////////////// DB
   ///////////////////////////////// SETUP///////////////////////////////////////////////

   public FlightDatabase(String password)
   {
      try
      {
         Class.forName("org.postgresql.Driver");
         c = DriverManager.getConnection(
               "jdbc:postgresql://localhost:5432/postgres", "postgres",
               password);
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

      }
      catch (Exception e)
      {
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
         System.exit(0);
         System.out.println("Database query ok ");
      }
   }

   public void addFlight(Flight flight)
   {
      try
      {
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

         System.out.println("INSERT INTO zair.\"Flight\" " + "VALUES ('"
               + flightID + "', '" + origin + "', '" + destination + "', '"
               + dateOfArrival + "', '" + dateOfDeparture + "', '"
               + timeDeparture + "', '" + timeArrival + "', " + numberOfTickets
               + ", " + numberOfTicketsLeft + ", " + price + ");");

         stmt.executeUpdate("INSERT INTO zair.\"Flight\" " + "VALUES ('"
               + flightID + "', '" + origin + "', '" + destination + "', '"
               + dateOfArrival + "', '" + dateOfDeparture + "', '"
               + timeDeparture + "', '" + timeArrival + "', " + numberOfTickets
               + ", " + numberOfTicketsLeft + ", " + price + ");");

      }
      catch (SQLException e)
      {
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
         System.exit(0);
         System.out.println("Database query ok ");
      }
   }

  

   @Override
   public void removeFlight(int index)
   {
      try
      {
         stmt = c.createStatement();
         stmt.executeUpdate("DELETE FROM Flight WHERE index =" + index + "");
      }
      catch (SQLException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

   }

   @Override
   public Flight[] getTodayFlights()
   {

      Date date = new Date(); // it will create todays date
      Flight[] fl = null;
      try
      {
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

         while (resultSet.next())
         {

            Date dateDeparture = StringToDate (resultSet1.getString("dateOfDeparture")); 
            Date dateArrival = StringToDate (resultSet1.getString("dateOfArrival"));
            String origin = resultSet1.getString("origin");
            String destination = resultSet1.getString("destination");
            String timeDeparture = resultSet1.getString("timeOfDeparture");
            String timeArrival = resultSet1.getString("timeOfArrival");
            double price = resultSet1.getDouble("price");
            int numberOfTicketsLeft = resultSet1.getInt("nrOfTicketsLeft");
            int nrOfTickets = resultSet1.getInt("nrOfTickets");

            fl[i] = new Flight(dateDeparture, dateArrival, origin, destination,
                  timeDeparture, timeArrival, price);

            i++;
         }
         
         
       

      }
      catch (SQLException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return fl;
   }

   
   
   private Date StringToDate(String string) {
      int day = Integer.parseInt(string.substring(0,2));
      int  month = Integer.parseInt(string.substring(3,5));
      int  year = Integer.parseInt(string.substring(6,10));
       
     Date date = new Date(day,month,year);
      return date;
   }
   
   
   @Override
   public Flight[] getAllFlights()
   {
      Flight[] fl = null;
      try
      {
         stmt = c.createStatement();
         String selectSQL = "SELECT COUNT(*) AS total FROM Flight";
         PreparedStatement preparedStatement;
         preparedStatement = c.prepareStatement(selectSQL);
         ResultSet resultSet1 = preparedStatement.executeQuery();

         int amount = resultSet1.getInt("total");
         fl = new Flight[amount];

         int i = 0;
         while (resultSet1.next())
         {

            Date dateDeparture = StringToDate (resultSet1.getString("dateOfDeparture")); 
            Date dateArrival = StringToDate (resultSet1.getString("dateOfArrival"));
            String origin = resultSet1.getString("origin");
            String destination = resultSet1.getString("destination");
            String timeDeparture = resultSet1.getString("timeOfDeparture");
            String timeArrival = resultSet1.getString("timeOfArrival");
            double price = resultSet1.getDouble("price");
            int numberOfTicketsLeft = resultSet1.getInt("nrOfTicketsLeft");
            int nrOfTickets = resultSet1.getInt("nrOfTickets");

            fl[i] = new Flight(dateDeparture, dateArrival, origin, destination,
                  timeDeparture, timeArrival, price);
            i++;
         }
      }
      catch (SQLException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
         
         return fl;
  

   }

   @Override
   public Flight getFlight(String id)
   {
      
      Flight fl = null;
      try
      {
         stmt = c.createStatement();
        
         String selectSQL = "SELECT * FROM Flight WHERE flightID = ?";
         PreparedStatement preparedStatement;
         preparedStatement = c.prepareStatement(selectSQL);
         preparedStatement.setString(1, id);
         ResultSet resultSet1 = preparedStatement.executeQuery();
         
         
         while (resultSet1.next())
         {

            Date dateDeparture = StringToDate (resultSet1.getString("dateOfDeparture")); 
            Date dateArrival = StringToDate (resultSet1.getString("dateOfArrival"));
            String origin = resultSet1.getString("origin");
            String destination = resultSet1.getString("destination");
            String timeDeparture = resultSet1.getString("timeOfDeparture");
            String timeArrival = resultSet1.getString("timeOfArrival");
            double price = resultSet1.getDouble("price");
            int numberOfTicketsLeft = resultSet1.getInt("nrOfTicketsLeft");
            int nrOfTickets = resultSet1.getInt("nrOfTickets");

            fl =  new Flight(dateDeparture, dateArrival, origin, destination,
                  timeDeparture, timeArrival, price);
         }
         
      }
      catch (SQLException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return fl;
   }
   
//   public void bookTicket(Ticket ticket)
//   {
//     
//      String id = ticket.getFlightID();
//      Flight fl = getFlight(id);
//    //  fl.bookTicket(counter);
//      //////////////////////////////////?
//      
//      try
//      {
//         stmt = c.createStatement();
// 
//         stmt.executeUpdate("INSERT INTO zair.\"Flight\" " + "VALUES ('"
//               + ticket.getFlightID() + "', '" + ticket.getFlightID()+ "', '" + ticket.getSeat() +");");
//      
//      }
//      catch (SQLException e)
//      {
//         // TODO Auto-generated catch block
//         e.printStackTrace();
//      }
//      
//     
//   }
   
   
   
   


  
  

}
