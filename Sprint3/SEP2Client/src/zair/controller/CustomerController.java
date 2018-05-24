package zair.controller;

import zair.domain.mediator.FlightModel;
import zair.domain.model.Customer;
import zair.domain.model.Flight;
import zair.domain.model.Ticket;
import zair.view.CustomerView;

public class CustomerController
{
   private FlightModel model;
   private CustomerView view;
   
   public CustomerController(FlightModel model, CustomerView view)
   {
      this.model = model;
      this.view = view;
      view.switchPanelTo("homePanel");
   }
   
   public void execute(String what)
   {
      switch (what)
      {
         case "bookPanel": 
            if (view.isRowSelected("flightTable"))
            {
               view.switchPanelTo("bookPanel");
               int index = view.getSelectedIndex("flightTable");
               Flight flight = model.getFlight(index);
               loadSelectedFlight(flight);
            }
            else
            {
               view.launchOption("Please select a flight to book!");
            }
            break;
         case "confirmation":
            if (view.isRowSelected("seatTable") &&  (view.isRowSelected("flightTable")))
            {
               Ticket ticket = new Ticket(view.getSelectedIndex("seatTable"), model.getFlight(view.getSelectedIndex("flightTable")));
               getLoggedInCustomer().addTicket(ticket);
               Customer customer = getLoggedInCustomer();
               customer.addTicket(ticket);
               view.launchOption("Successfully booked. Thank you!");
               loadCustomer(customer);
               loadFlights(model.getAllFlights());
               view.switchPanelTo("mainPanel");
            }
            else
            {
               view.launchOption("Please select a seat.");
            }
         break;  
         case "viewProfile": view.switchPanelTo("viewProfilePanel");
         break;
         case "back": view.switchPanelTo("mainPanel");
         break;
         case "logIn": 
         Customer customer = getLoggedInCustomer();
         if (customer == null)
         {
            view.launchOption("Username not found!");
         }
         else if (customer != null)
         {
            loadCustomer(customer);
            loadFlights(model.getAllFlights());
            view.switchPanelTo("mainPanel");
         }
         break;
         case "signUp": view.switchPanelTo("signUpPanel");
         break;
         case "register": 
         String fname = view.getTextFieldInput("firstName");
         String lname = view.getTextFieldInput("lastName");
         String email = view.getTextFieldInput("email");
         String username = view.getTextFieldInput("usernameField");
         String password = view.getTextFieldInput("passwordField");
         String phone = view.getTextFieldInput("phone");
         String passportNo = view.getTextFieldInput("passportNo");
         Customer cust = new Customer(fname, lname, email, phone, passportNo, username, password);
         model.addCustomer(cust);
         view.launchOption("Successfully added!");
         view.switchPanelTo("homePanel");
         break;
         case "signOut": view.switchPanelTo("homePanel");
         break;
      }
   }
   
   private void loadCustomer(Customer customer)
   {
      String customerDetails = customer.getName() + "<" + customer.getEmail() + "<" + customer.getPhone() + "<" + customer.getPassportNo();
      String[] tickets = new String[customer.getTickets().length];
      for (int i = 0; i < customer.getTickets().length; i++)
      {
         tickets[i] = customer.getTickets()[i].getTicketID() + "<" + customer.getTickets()[i].getFlight().getOrigin().getLocation() 
               + "<" + customer.getTickets()[i].getFlight().getDestination().getLocation() + "<" + customer.getTickets()[i].getFlight().getDateDeparture()
               + " - " + customer.getTickets()[i].getFlight().getDateArrival() + "<" + customer.getTickets()[i].getFlight().getTimeDeparture()
               + " - " + customer.getTickets()[i].getFlight().getTimeArrival() + "<"
               + customer.getTickets()[i].getSeatNumber();
      }
      view.loadCustomer(customerDetails, tickets);
   }
   
   private void loadFlights(Flight[] flights)
   {
      String[] flight = new String[flights.length];
      for (int i = 0; i < flights.length; i++)
      {
         flight[i] = flights[i].getOrigin().getLocation() + "<" + flights[i].getDestination().getLocation() + "<" + flights[i].getDateDeparture() + " - "
               + flights[i].getDateArrival() + "<" + flights[i].getTimeDeparture() + " - " + flights[i].getTimeArrival();
      }
      
      view.loadFlights(flight);
   }
   
   private void loadSelectedFlight(Flight flight)
   {
      String flightDetails = flight.getId() + "<" + flight.getDateDeparture() + "<" + flight.getDateArrival()
      + "<" + flight.getTimeDeparture() + "<" + flight.getTimeArrival() + "<" + flight.getOrigin().getLocation()
      + "<" + flight.getDestination().getLocation();
      String[] seats = new String[flight.getAvailableSeats().length];
      for (int i = 0; i < flight.getAvailableSeats().length; i++)
      {
         seats[i] = flight.getAvailableSeats()[i].toString();
      }
      view.loadSpecificFlight(flightDetails, seats);
   }
   
   private Customer getLoggedInCustomer()
   {
      String username = view.getTextFieldInput("username");
      String password = view.getTextFieldInput("password");
      Customer customer = model.getCustomerByCredentials(username, password);
      return customer;
   }
   
}
