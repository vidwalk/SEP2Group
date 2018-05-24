package zair.database;

import zair.domain.model.Flight;
import zair.domain.model.Ticket;

public interface FlightTarget
{

   public void addFlight(Flight flight);
   public void removeFlight(int index);
   public Flight[] getTodayFlights();
   public Flight[] getAllFlights();
   public Flight getFlight(String id);
   
}
