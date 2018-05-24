package zair.domain.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable
{

   private String customerNo;
   private String fname;
   private String lname;
   private String email;
   private String phone;
   private String passportNo;
   private ArrayList<Ticket> tickets;
   private Credentials credentials;

   public Customer(String fname,String lname,String email, String phone, String passportNo, String userId, String password) {
      this.fname = fname;
      this.lname = lname;
      this.email = email;
      this.passportNo = passportNo;
      this.phone = phone;
      this.customerNo = fname + phone;
      credentials = new Credentials(userId, password);
      tickets = new ArrayList<Ticket>();
   }

   public Ticket[] getTickets() {
      Ticket[] allTickets = new Ticket[tickets.size()];
      for (int i = 0; i < tickets.size(); i++)
      {
         allTickets[i] = tickets.get(i);
      }
      
      return allTickets;
   }
   
   public void addTicket(Ticket ticket)
   {
      tickets.add(ticket);
   }
   
   public String getEmail()
   {
	   return email;
   }
   
   public String getName()
   {
      return fname + " " + lname;
   }
   
   public String getPhone()
   {
      return phone;
   }
   
   public String getPassportNo()
   {
      return passportNo;
   }
   
   public Credentials getCredentials()
   {
      return credentials;
   }
   
   public String getId()
   {
      return customerNo;
   }
}
