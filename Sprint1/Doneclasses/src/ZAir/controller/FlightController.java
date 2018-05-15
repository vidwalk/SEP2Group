package zair.controller;

import java.util.Collection;
import java.util.Observable;

import javax.swing.SwingUtilities;

import zair.domain.mediator.FlightModel;
import zair.domain.model.Date;
import zair.domain.model.Flight;
import zair.domain.model.FlightDetails;
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
            String[] parts = view.get("departure_date").split("/");
            String[] parts1 = view.get("arrival_date").split("/");
            Date departureDate = new Date(Integer.parseInt(parts[0]),
                  Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
            Date arrivalDate = new Date(Integer.parseInt(parts1[0]),
                  Integer.parseInt(parts1[1]), Integer.parseInt(parts1[2]));
            Flight flight = new Flight(departureDate, arrivalDate,
                  view.get("origin"), view.get("destination"),
                  view.get("departure_time"), view.get("arrival_time"),
                  Double.parseDouble(view.get("price")), 40, 40);
            model.addFlight(flight);
            view.launchOption("Successfully added");
            reloadFlights(model.getAllFlights());
            break;
         case "back from add flight":
            view.switchPanelTo("flight-panel");
            break;
         case "status panel":
            view.switchPanelTo("status-panel");
            break;
         case "remove-flight":
            model.removeFlight(Integer.parseInt(view.get("flights")));
            view.launchOption("Successfully removed");
            reloadFlights(model.getAllFlights());
            break;
         case "exit":
            System.exit(1);
            break;
         case "search flight":
            Flight result = model.getFlight(view.get("search"));
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
               flights[i] = "Id: " + flightList[i].getId() + "; Itinerary: " + flightList[i].getOrigin().getLocation() + " - " + flightList[i].getDestination().getLocation()
                     + "; Date: " + flightList[i].getDateDeparture() + " - " + flightList[i].getDateArrival() 
                     + "; Time: " + flightList[i].getTimeDeparture() + " - " + flightList[i].getTimeArrival()
                     + "; Price: " + flightList[i].getPrice() + "; Tickets left: " + flightList[i].getNumberOfTicketsLeft();
            }
            view.loadFlights(flights);
   }
   
}
