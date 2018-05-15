package zair.domain.mediator;

import zair.domain.model.Flight;

public interface FlightModel
{

   public void addFlight(Flight flight);
   public void removeFlight(int index);
   public Flight[] getTodayFlights();
   public Flight[] getAllFlights();
   public Flight getFlight(String id);
}
