package zair.domain.mediator;

import java.sql.SQLException;
import java.util.ArrayList;

import utility.persistence.MyDatabase;
import zair.domain.model.Credentials;
import zair.domain.model.Customer;
import zair.domain.model.Date;
import zair.domain.model.Flight;
import zair.domain.model.Seat;
import zair.domain.model.Ticket;

public class FlightDatabaseAdapter implements TargetDatabase
{
   
   private MyDatabase database;
   
   public FlightDatabaseAdapter(String driver, String url, String user, String pw)
   {
      try
      {
         database = new MyDatabase(driver, url, user, pw);
      }
      catch (ClassNotFoundException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   @Override
   public void addFlight(Flight flight)
   {
      String dateOfArrival = flight.getDateArrival().toString();
      String dateOfDeparture = flight.getDateDeparture().toString();
      String origin = "" + flight.getOrigin().getInitials();
      String destination = "" + flight.getDestination().getInitials();
      String timeDeparture = flight.getTimeDeparture().toString();
      String timeArrival = flight.getTimeArrival().toString();
      String price = "" + flight.getPrice();
      String numberOfTickets = "" + flight.getNumberOfTicketsLeft();

      String flightID = flight.getId().toString();
      String statement = "INSERT INTO Flight VALUES ('" + flightID + "', '" + origin + "', '"
            + destination + "', " + "to_date(" + "'" + dateOfDeparture + "'" + "," + "'" + "DD/MM/YYYY" + "'" + "), " + "to_date(" + "'" + dateOfArrival + "'" + "," + "'" + "DD/MM/YYYY" + "'" + "), '" + timeDeparture + "', '"
            + timeArrival + "', '" + numberOfTickets + "', '" + price + "');";
      
      try
      {
         database.update(statement, null);
      }
      catch (SQLException e)
      {
         e.printStackTrace();
      }
   }

   @Override
   public void removeFlight(String flightID)
   {
      String statement = "DELETE FROM Seat WHERE flightID = '" + flightID + "';";
      String statement1 = "DELETE FROM Flight WHERE flightID = '" + flightID + "';";
      try
      {
         database.update(statement, null);
         database.update(statement1, null);
      }
      catch (SQLException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   
   private Date StringToDate(String string) {
      String[] parts = string.split("-");
      int year = Integer.parseInt(parts[0]);
      int month = Integer.parseInt(parts[1].substring(1));
      int day = Integer.parseInt(parts[2]);

      Date date = new Date(day, month, year);
      return date;
   }

   @Override
   public Flight[] getAllFlights()
   {  
      String statement1 = "SELECT * FROM Flight;";
      ArrayList<Object[]> results = null;
      try
      {
         results = database.query(statement1, null);
      }
      catch (SQLException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      Flight[] flights = new Flight[results.size()];
      for (int i = 0; i < results.size(); i++)
      {
         Object[] row = results.get(i);
         String flightId = row[0].toString();
         String origin = row[1].toString();
         String destination = row[2].toString();
         Date dateDeparture = StringToDate(row[3].toString());
         Date dateArrival = StringToDate(row[4].toString());
         String timeDeparture = row[5].toString().substring(0, 5);
         String timeArrival = row[6].toString().substring(0, 5);
         double price = Double.parseDouble(row[8].toString());
         flights[i] = new Flight(dateDeparture, dateArrival, origin, destination, timeDeparture, timeArrival, price);
         ArrayList<Seat> seats = new ArrayList<Seat>();
         Seat[] s1 = getAllSeats(flightId);
         for (int j = 0; j < s1.length; j++) {
            seats.add(s1[j]);
         }
         flights[i].setAllSeats(seats);
      }
      
      return flights;
   }

   @Override
   public void addCustomer(Customer customer)
   {
      String customerID = customer.getId();
      String[] names = customer.getName().split("\\s+");
      String fname = names[0];
      String lname = names[1];
      String email = customer.getEmail();
      String phone = customer.getPhone();
      String passportNo = customer.getPassportNo();
      String userID = customer.getCredentials().getUserId();
      String password = customer.getCredentials().getPassword();
      
      String statement = "INSERT INTO Customer VALUES ('" + customerID + "', '" + fname + "', '"
            + lname + "', '" + email + "', '" + passportNo + "', '" + phone + "');";
      String statement1 = "INSERT INTO CustomerCredentials VALUES ('" + customerID + "', '"
            + userID + "', '" + password + "');";
      
      try
      {
         database.update(statement, null);
         database.update(statement1, null);
      }
      catch (SQLException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   @Override
   public void saveSeats(Flight flight)
   {
      for (int i = 0; i < flight.getAllSeats().size(); i++) {
            String seatPo = flight.getAllSeats().get(i).getSeatValue();
            String seatValue = "" + flight.getAllSeats().get(i).isBooked();
            String flightID = "" + flight.getId();

            String statement = "INSERT INTO Seat VALUES ('" + seatPo + "', '" + seatValue + "', '"
                  + flightID + "');";
            try
            {
               database.update(statement, null);
            }
            catch (SQLException e)
            {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
      }
   }

   @Override
   public Customer[] getAllCustomers()
   {
      String statement = "SELECT * FROM Customer;";
      ArrayList<Object[]> results = null;
      try
      {
         results = database.query(statement, null);
      }
      catch (SQLException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      Customer[] customers = new Customer[results.size()];
      for (int i = 0; i < results.size(); i++)
      {
         Object[] row = results.get(i);
         String customerId = row[0].toString();
         String fname = row[1].toString();
         String lname = row[2].toString();
         String email = row[3].toString();
         String passportNo = row[4].toString();
         String phone = row[5].toString();
         customers[i] = new Customer(fname, lname, email, phone, passportNo,
               getCustomerCredentials(customerId).getUserId(),
               getCustomerCredentials(customerId).getPassword()); 
         Ticket[] tickets = getTickets(customerId);
         for (int j = 0; j < tickets.length; j++) {
            customers[i].addTicket(tickets[j]);
         }
      }
      
      return customers;
   }

   @Override
   public Credentials getCustomerCredentials(String id)
   {
       String statement = "SELECT * FROM CustomerCredentials WHERE customerID = '" + id + "';";
       ArrayList<Object[]> result = null;
      try
      {
         result = database.query(statement, null);
      }
      catch (SQLException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
       Object[] row = result.get(0);
       String userID = row[1].toString();
       String password = row[2].toString();
       Credentials credentials = new Credentials(userID, password);
       return credentials;
   }

   @Override
   public void bookTicket(String flightID, String customerID, String seatValue,
         Ticket ticket)
   {
      String statement = "INSERT INTO Ticket VALUES ('" + ticket.getTicketID() + "', '" + flightID + "', '"
            + seatValue + "', '" + customerID + "');";

      String statement1 = "UPDATE Seat SET seatValue = true WHERE flightID = '" + flightID
               + "' AND " + "seatPo = '" + seatValue + "';";

      try
      {
         database.update(statement, null);
         database.update(statement1, null);
      }
      catch (SQLException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   @Override
   public Ticket[] getTickets(String customerID)
   {
      String statement = "SELECT * FROM Ticket WHERE customerID = '" + customerID +"'";
      ArrayList<Object[]> results = null;
      try
      {
         results = database.query(statement, null);
      }
      catch (SQLException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      Ticket[] tickets = new Ticket[results.size()];
      for (int i = 0; i < results.size(); i++)
      {
         Object[] row = results.get(i);
         String seatPo = row[2].toString();
         String flightId = row[1].toString();
         tickets[i] = new Ticket(seatPo, getFlight(flightId));
      }
      return tickets;
   }

   @Override
   public Flight getFlight(String id)
   {
         String statement = "SELECT * FROM Flight WHERE flightID = '" + id + "'";
         ArrayList<Object[]> results = null;
         try
         {
            results = database.query(statement, null);
         }
         catch (SQLException e)
         {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         Object[] row = results.get(0);
         String flightId = row[0].toString();
         String origin = row[1].toString();
         String destination = row[2].toString();
         Date dateDeparture = StringToDate(row[3].toString());
         Date dateArrival = StringToDate(row[4].toString());
         String timeDeparture = row[5].toString().substring(0, 5);
         String timeArrival = row[6].toString().substring(0, 5);
         double price = Double.parseDouble(row[8].toString());
         Flight flight = new Flight(dateDeparture, dateArrival, origin, destination, timeDeparture, timeArrival, price);
         ArrayList<Seat> seats = new ArrayList<Seat>();
         Seat[] s1 = getAllSeats(flightId);
         for (int j = 0; j < s1.length; j++) {
            seats.add(s1[j]);
         }
         flight.setAllSeats(seats);
         
         return flight;
   }
   
   private Seat[] getAllSeats(String flightID) {
         String statement = "SELECT * FROM Seat WHERE flightID = '" + flightID + "'";
         ArrayList<Object[]> results = null;
         try
         {
            results = database.query(statement, null);
         }
         catch (SQLException e)
         {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         Seat[] seats = new Seat[results.size()]; 
         for (int i = 0; i < results.size(); i++)
         {
            Object[] row = results.get(i);
            String seatPo = row[0].toString();
            String seatValue = row[1].toString();
            seats[i] = new Seat(seatPo);
            if (seatValue.equals("true"))
               seats[i].setBooked();
         }
         return seats;

   }

}
