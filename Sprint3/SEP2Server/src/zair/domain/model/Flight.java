package zair.domain.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Flight implements Serializable{
	private Seat[] seats;
	private Date dateDeparture;
	private Date dateArrival;
	private AbstractPlaces origin;
	private AbstractPlaces destination;
	private AbstractTime timeDeparture;
	private AbstractTime timeArrival;
	private double price;
	private String flightID;

	public Flight(Date dateDeparture, Date dateArrival, String origin, String destination, String timeDeparture,
			String timeArrival, double price) {
		this.dateDeparture = dateDeparture;
		this.dateArrival = dateArrival;
		this.origin = PlacesFactory.getPlace(origin);
		this.destination = PlacesFactory.getPlace(destination);
		this.timeDeparture = TimeFactory.getTime(timeDeparture);
		this.timeArrival = TimeFactory.getTime(timeArrival);
		this.price = price;
		flightID = createFlightID();
		seats = Seat.values();
	}

	public Seat[] getSeats() {
		return seats;
	}

	private String createFlightID() {
		String[] parts = dateDeparture.toString().split("/");
		String[] parts1 = timeDeparture.toString().split(":");
		String id = "";
		id += destination.getInitials();
		id += origin.getInitials();
		id += parts[0] + parts[1] + parts[2];
		id += parts1[0] + parts1[1];

		return id;
	}

	public Date getDateDeparture() {
		return dateDeparture;
	}

	public void setDateDeparture(Date dateDeparture) {
		this.dateDeparture = dateDeparture;
	}

	public Date getDateArrival() {
		return dateArrival;
	}

	public void setDateArrival(Date dateArrival) {
		this.dateArrival = dateArrival;
	}

	public AbstractPlaces getOrigin() {
		return origin;
	}

	public void setOrigin(AbstractPlaces origin) {
		this.origin = origin;
	}

	public AbstractPlaces getDestination() {
		return destination;
	}

	public void setDestination(AbstractPlaces destination) {
		this.destination = destination;
	}

	public AbstractTime getTimeDeparture() {
		return timeDeparture;
	}

	public void setTimeDeparture(AbstractTime timeDeparture) {
		this.timeDeparture = timeDeparture;
	}

	public AbstractTime getTimeArrival() {
		return timeArrival;
	}

	public void setTimeArrival(AbstractTime timeArrival) {
		this.timeArrival = timeArrival;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public Seat[] getAvailableSeats()
	{
	   ArrayList<Seat> output = new ArrayList<>();
	   for (int i = 0; i < seats.length; i++)
	   {
	      if (seats[i].getSeatValue() == false)
	      {
	         output.add(seats[i]);
	      }
	   }
	   
	   Seat[] array = new Seat[output.size()];
	   for (int i = 0; i < array.length; i++)
	   {
	      array[i] = output.get(i);
	   }
	   
	   return array;
	}

	public int getNumberOfTicketsLeft() {
		return getAvailableSeats().length;
	}
	
	public void setSeatOccupied(Seat seat)
	{
	   for (int i = 0; i < seats.length; i++)
	   {
	      if (seats[i].equals(seat))
	      {
	         seats[i].book();
	      }
	   }
	}

	public String getId() {
		return flightID;
	}
	
	public Seat[] getAllSeats()
	{
	   return seats;
	}
}
