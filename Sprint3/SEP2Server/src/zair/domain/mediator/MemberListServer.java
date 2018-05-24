package zair.domain.mediator;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import zair.domain.model.Customer;
import zair.domain.model.Flight;

public class MemberListServer implements RemoteFlightList
{
   
   private FlightModel list;
   private static final long serialVersionUID = 1L;

   public MemberListServer(FlightModel list) {
      this.list = list;
      startRegistry();
      try {
         UnicastRemoteObject.exportObject(this, 0);
         Naming.rebind("Flight", this);
      }
      catch(RemoteException | MalformedURLException e)
      {
         e.printStackTrace();
      }
   }
      
   private void startRegistry() {
      try {
         Registry reg = LocateRegistry.createRegistry(1099);
      } catch (RemoteException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   @Override
   public Flight[] getTodayFlights()
   {
      // TODO Auto-generated method stub
      return null;
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
   public Customer getCustomerBy(String username, String password)
   {
      return list.getCustomerByCredentials(username, password);
   }

   @Override
   public Customer[] getAllCustomers()
   {
      return list.getAllCustomers();
   }

   @Override
   public void addCustomer(Customer customer) throws RemoteException
   {
      list.addCustomer(customer);
   }
   
}
