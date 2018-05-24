package zair.domain.mediator;

import zair.domain.model.Flight;
import zair.domain.model.FlightList;
import zair.domain.model.Ticket;

public interface FlightTarget
{

   public void save(Flight flight);
   public void remove(int index);
   public FlightList loadAll();
   public Flight load(String id);
   public void clearAll(String tableName);

}
