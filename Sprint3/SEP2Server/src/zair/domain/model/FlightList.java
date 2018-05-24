package zair.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import zair.domain.mediator.FlightModel;

public class FlightList implements Serializable
{
   private ArrayList<Flight> flights;
   private Calendar currentDate = GregorianCalendar.getInstance();

   public FlightList() {
      flights = new ArrayList<>();
   }

   public void addFlight(Flight flight) {
      flights.add(flight);
   }

   public void removeFlight(int index) {
      flights.remove(index);
   }

   public Flight[] getTodayFlights() {
      Flight[] result = new Flight[flights.size()];
      int count = 0;
      for (int i = 0; i < flights.size(); i++)
         if (flights.get(i).getDateArrival().getDay() == currentDate.get(Calendar.DAY_OF_MONTH)) {
            result[count] = flights.get(i);
            count++;
         }
      return result;
   }
   
   public Flight[] getAllFlights()
   {
      Flight[] result = new Flight[flights.size()];
      for (int i = 0; i < flights.size(); i++)
      {
         result[i] = flights.get(i);
      }
      return result;
   }
   
   public Flight getFlight(String id)
   {
      Flight result = null;
      for (int i = 0; i < flights.size(); i++)
      {
         if (flights.get(i).getId().equals(id))
         {
            result = flights.get(i);
         }
      }
      return result;
   }
   
   public Flight getFlight(int index)
   {
      return flights.get(index);
   }
}
