import zair.domain.model.Date;
import zair.domain.model.Flight;
import zair.domain.model.Ticket;

public class test
{
   public static void main(String[] args)
   {
      Date date = new Date();
      Flight flight = new Flight(date, date, "Copenhagen", "Bucharest", "8:00", "8:00", 200);
      for (int i = 0; i < flight.getAvailableSeats().length; i++)
      {
         System.out.println(flight.getAvailableSeats()[i]);
      }
      System.out.println("FUCKMEMEEMMEEMEMEM");
      Ticket ticket = new Ticket(0, flight);
      System.out.println(ticket.getSeatNumber());
      System.out.println("FUCKMEMEEMMEEMEMEM");
      for (int i = 0; i < flight.getAvailableSeats().length; i++)
      {
         System.out.println(flight.getAvailableSeats()[i]);
      }
   }
}
