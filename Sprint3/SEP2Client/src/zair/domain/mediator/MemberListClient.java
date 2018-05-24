package zair.domain.mediator;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import zair.domain.model.Customer;
import zair.domain.model.Flight;

public class MemberListClient implements RemoteFlightList {

	private RemoteFlightList list;
	public MemberListClient(String host, int port) throws IOException, NotBoundException {
		
		//list = (RemoteFlightList) Naming.lookup("rmi://localhost:1099/Flight");
		list = (RemoteFlightList) Naming.lookup("rmi://" + host + ":" + port + "/Flight");
	}


	@Override
	public Flight getFlight(int index) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Customer getCustomerBy(String username, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Customer[] getAllCustomers() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addCustomer(Customer customer) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Flight[] getTodayFlights() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Flight[] getAllFlights() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
