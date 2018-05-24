package zair.domain.mediator;

import zair.domain.model.Customer;
import zair.domain.model.Flight;

public interface FlightModel
{

   void addFlight(Flight flight);
   void removeFlight(int index);
   Flight[] getTodayFlights();
   Flight[] getAllFlights();
   Flight getFlight(int index);
   Flight getFlight(String id);
   Customer getCustomerByCredentials(String username, String password);
   Customer[] getAllCustomers();
   void addCustomer(Customer customer);
}
