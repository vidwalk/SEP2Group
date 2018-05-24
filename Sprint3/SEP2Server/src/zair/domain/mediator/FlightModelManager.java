package zair.domain.mediator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;

import zair.domain.model.Customer;
import zair.domain.model.CustomerList;
import zair.domain.model.Flight;
import zair.domain.model.FlightList;
import zair.domain.model.Log;

public class FlightModelManager extends Observable implements FlightModel
{
   private FlightList list;
   private CustomerList customerList;
   private MemberListServer server;
   
   public FlightModelManager() {
      list = new FlightList();
      customerList = new CustomerList();
      server = new MemberListServer(this);
   }
 
   public void addFlight(Flight flight) {
      list.addFlight(flight);
      setChanged();
      notifyObservers(Log.getInstance().getTimestamp() + " Flight added");
   }
   
   public void removeFlight(int index) {
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
   public Flight getFlight(int index)
   {
      return list.getFlight(index);
   }

   @Override
   public Flight getFlight(String id)
   {
      return list.getFlight(id);
   }

   @Override
   public Customer getCustomerByCredentials(String username, String password)
   {
      return customerList.getCustomerByCredentials(username, password);
   }

   @Override
   public Customer[] getAllCustomers()
   {
      return customerList.getAllCustomers();
   }

   @Override
   public void addCustomer(Customer customer)
   {
      customerList.addCustomer(customer);
   }
   
   
}
