package zair.domain.mediator;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.Observable;

import zair.domain.model.Customer;
import zair.domain.model.Flight;


public class FlightModelManager extends Observable implements FlightModel
{
	private RemoteFlightList list;
	private static final String HOST = Init.getInstance().getIp();
	private static final int PORT = Init.getInstance().getPort();
	public FlightModelManager() throws IOException {
		try
      {
         list = new MemberListClient(HOST, PORT);
      }
      catch (NotBoundException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
	}



@Override
public Flight getFlight(int index) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Customer[] getAllCustomers() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Customer getCustomerByCredentials(String username, String password) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void addCustomer(Customer customer) {
	// TODO Auto-generated method stub
	
}



@Override
public Flight[] getTodayFlights() {
	// TODO Auto-generated method stub
	return null;
}



@Override
public Flight[] getAllFlights() {
	// TODO Auto-generated method stub
	return null;
}


}
