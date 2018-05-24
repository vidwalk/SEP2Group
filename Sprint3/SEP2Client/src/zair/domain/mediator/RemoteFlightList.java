package zair.domain.mediator;
import java.rmi.Remote;
import java.rmi.RemoteException;

import zair.domain.model.Customer;
import zair.domain.model.Flight;

public interface RemoteFlightList extends Remote
{
	   Flight[] getTodayFlights() throws RemoteException;
	   Flight[] getAllFlights() throws RemoteException;
	   Flight getFlight(int index) throws RemoteException;
	   Customer getCustomerBy(String username, String password) throws RemoteException;
	   Customer[] getAllCustomers() throws RemoteException;
	   void addCustomer(Customer customer) throws RemoteException;
}
