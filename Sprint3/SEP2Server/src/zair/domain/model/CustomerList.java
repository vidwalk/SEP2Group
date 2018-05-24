package zair.domain.model;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomerList implements Serializable {
	private ArrayList<Customer> customers;

	public CustomerList()
	{
		customers = new ArrayList();
	}

	public void addCustomer(Customer customer)
	{
		customers.add(customer);
	}

	 public Customer[] getAllCustomers()
	   {
		 Customer[] result = new Customer[customers.size()];
	      for (int i = 0; i < customers.size(); i++)
	      {
	         result[i] = customers.get(i);
	      }
	      return result;
	   }

	 public Customer getCustomerByCredentials(String username, String password)
	   {
	      Customer result = null;
	      for (int i = 0; i < customers.size(); i++)
	      {
	         if (customers.get(i).getCredentials().getUserId().equals(username) && customers.get(i).getCredentials().getPassword().equals(password))
	         {
	            result = customers.get(i);
	         }
	      }
	      return result;
	   }
}
