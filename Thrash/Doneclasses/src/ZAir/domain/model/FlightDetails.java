package ZAir.domain.model;

import java.util.Random;

public abstract class FlightDetails {

	private Date dateDeparture;
	private Date dateArrival;
	private AbstractPlaces origin;
	private AbstractPlaces destination;
	private AbstractTime timeDeparture;
	private AbstractTime timeArrival;
	private double price;
	private int numberOfTicketsLeft;
	private String flightID;

	public FlightDetails(Date dateDeparture, Date dateArrival, AbstractPlaces origin,
			AbstractPlaces destination, AbstractTime timeDeparture, AbstractTime timeArrival,
			double price, int numberOfTicketsLeft)
	{
		this.dateDeparture = dateDeparture;
		this.dateArrival = dateArrival;
		this.origin = origin;
		this.destination = destination;
		this.timeDeparture = timeDeparture;
		this.timeArrival = timeArrival;
		this.price = price;
		this.numberOfTicketsLeft = numberOfTicketsLeft;
		flightID = createFlightID();
	}

	private String createFlightID()
	{
		//TODO
		String id = "";
		id += destination.getInitials();
		id += origin.getInitials();
		id += dateDeparture.getDay();
		id += dateDeparture.getMonth();
		id += ("" + dateDeparture.getYear()).charAt(2) + ("" + dateDeparture.getYear()).charAt(3);
		Random rand = new Random();
		int  n = rand.nextInt(99) + 1;

		return id;
	}

	public Date getDateDeparture()
	{
		return dateDeparture;
	}

	public void setDateDeparture(Date dateDeparture)
	{
		this.dateDeparture = dateDeparture;
	}

	public Date getDateArrival()
	{
		return dateArrival;
	}

	public void setDateArrival(Date dateArrival)
	{
		this.dateArrival = dateArrival;
	}

	public AbstractPlaces getOrigin()
	{
		return origin;
	}

	public void setOrigin(AbstractPlaces origin)
	{
		this.origin = origin;
	}

	public AbstractPlaces getDestination()
	{
		return destination;
	}

	public void setDestination(AbstractPlaces destination)
	{
		this.destination = destination;
	}

	public AbstractTime getTimeDeparture()
	{
		return timeDeparture;
	}

	public void setTimeDeparture(AbstractTime timeDeparture)
	{
		this.timeDeparture = timeDeparture;
	}

	public AbstractTime getTimeArrival()
	{
		return timeArrival;
	}

	public void setTimeArrival(AbstractTime timeArrival)
	{
		this.timeArrival = timeArrival;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public int getNumberOfTicketsLeft()
	{
		return numberOfTicketsLeft;
	}

	public void setNumberOfTicketsLeft(int numberOfTicketsLeft)
	{
		this.numberOfTicketsLeft = numberOfTicketsLeft;
	}
}
