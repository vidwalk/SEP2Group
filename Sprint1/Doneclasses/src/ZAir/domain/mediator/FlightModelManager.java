package zair.domain.mediator;

import java.util.Observable;

import zair.domain.model.Flight;
import zair.domain.model.FlightList;
import zair.domain.model.Log;

public class FlightModelManager extends Observable implements FlightModel
{
   private FlightList list;
   private MemberListServer server;
   
   public FlightModelManager() {
     list = new FlightList();
     server = new MemberListServer(this);
   }
 
   public synchronized void addFlight(Flight flight) {
      list.addFlight(flight);
      setChanged();
      notifyObservers(Log.getInstance().getTimestamp() + " Flight added");
   }
   
   public synchronized void removeFlight(int index) {
      list.removeFlight(index);
      setChanged();
      notifyObservers(Log.getInstance().getTimestamp().toString() + " Flight removed");
   }
   
   @Override
   public Flight[] getTodayFlights()
   {
      return list.getTodayFlights();
   }

   @Override
   public Flight[] getAllFlights()
   {
      return list.getAllFlights();
   }

   @Override
   public Flight getFlight(String id)
   {
      return list.getFlight(id);
   }
   
   
}
