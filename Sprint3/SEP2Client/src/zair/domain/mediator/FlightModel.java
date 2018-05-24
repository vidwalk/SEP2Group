package zair.domain.mediator;

import zair.domain.model.Customer;
import zair.domain.model.Flight;

public interface FlightModel
{
   Flight[] getTodayFlights();
   Flight[] getAllFlights();
   Flight getFlight(int index);
   Customer[] getAllCustomers();
   Customer getCustomerByCredentials(String username, String password);
   void addCustomer(Customer customer);
}
