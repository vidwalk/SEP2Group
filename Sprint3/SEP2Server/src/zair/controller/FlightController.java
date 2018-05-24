package zair.controller;

import java.util.Observable;
import zair.domain.mediator.FlightModel;
import zair.domain.model.Date;
import zair.domain.model.Flight;
import zair.view.FlightView;

public class FlightController
{
   private FlightModel model;
   private FlightView view;
   
   public FlightController(FlightModel model, FlightView view)
   {
      this.model = model;
      this.view = view;
      Observable obs = (Observable) this.model;
      obs.addObserver(view);
      view.showText("Registry created!");
      view.showText("Server started!");
      reloadFlights(model.getAllFlights());
   }
   
   public void execute(String what)
   {
      switch (what)
      {
         case "add": 
            view.switchPanelTo("add-flight");
            break;
         case "save flight":
            if (!view.getComboBoxItem("origin").equals(view.getComboBoxItem("destination")))
            {
               if (verifyDates(view.getDates("departure_date"), view.getDates("arrival_date"), view.getComboBoxItem("departure"), view.getComboBoxItem("arrival")))
               {
                  String[] parts = view.getDates("departure_date").split("/");
                  String[] parts1 = view.getDates("arrival_date").split("/");
                  Date departureDate = new Date(Integer.parseInt(parts[0]),
                        Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                  Date arrivalDate = new Date(Integer.parseInt(parts1[0]),
                        Integer.parseInt(parts1[1]), Integer.parseInt(parts1[2]));
                  Flight flight = new Flight(departureDate, arrivalDate,
                        view.getComboBoxItem("origin"), view.getComboBoxItem("destination"),
                        view.getComboBoxItem("departure"), view.getComboBoxItem("arrival"),
                        Double.parseDouble(view.getTextFieldInput("price")));
                  model.addFlight(flight);
                  view.launchOption("Successfully added");
                  reloadFlights(model.getAllFlights());
               }
               else
               {
                  view.launchOption("Make sure dates and times are not overlapping!");
               }
            }
            else
            {
               view.launchOption("Origin and destination must have different values!");
            }
            break;
         case "back from add flight":
            view.switchPanelTo("flight-panel");
            break;
         case "status panel":
            view.switchPanelTo("status-panel");
            break;
         case "remove-flight":
            if (view.isRowSelected())
            {
               model.removeFlight(view.getSelectedIndex());
               view.launchOption("Successfully removed");
               reloadFlights(model.getAllFlights());
            }
            else
            {
               view.launchOption("Please select a flight to delete!");
            }
            break;
         case "exit":
            System.exit(1);
            break;
         case "search flight":
            Flight result = model.getFlight(view.getTextFieldInput("searchTextField"));
            if (result == null)
            {
               view.launchOption("No flight with the id has been found!");
            }
            else
            {
               Flight[] array = new Flight[1];
               array[0] = result;
               reloadFlights(array);
            }
            break;
         case "reset view":
            reloadFlights(model.getAllFlights());
            break;
      }
   }
   
   private void reloadFlights(Flight[] flightList)
   {
            String[] flights = new String[flightList.length];
            for (int i = 0; i < flights.length; i++)
            {
               flights[i] = flightList[i].getId() + "<" + flightList[i].getOrigin().getLocation() + "<" + flightList[i].getDestination().getLocation()
                     + "<" + flightList[i].getDateDeparture() + " - " + flightList[i].getDateArrival() 
                     + "<" + flightList[i].getTimeDeparture() + " - " + flightList[i].getTimeArrival()
                     + "<" + flightList[i].getPrice() + "<" + flightList[i].getNumberOfTicketsLeft();
            }
            view.loadFlights(flights);
   }
   
   private boolean verifyDates(String date1, String date2, String time1, String time2)
   {
      String[] dateParts = date1.split("/");
      String[] dateParts1 = date2.split("/");
      Date departureDate = new Date(Integer.parseInt(dateParts[0]),
            Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
      Date arrivalDate = new Date(Integer.parseInt(dateParts1[0]),
            Integer.parseInt(dateParts1[1]), Integer.parseInt(dateParts1[2]));
      String[] departureTime = time1.split(":");
      String[] arrivalTime = time2.split(":");
      boolean valid = false;
      
      if (departureDate.isBefore(arrivalDate))
      {
         valid = true;
      }
      else if (departureDate.equals(arrivalDate))
      {
         if (Integer.parseInt(departureTime[0]) < Integer.parseInt(arrivalTime[0]))
         {
            valid = true;
         }
      }
      
      return valid;
   }
   
}
