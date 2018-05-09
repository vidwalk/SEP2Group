package ZAir.domain.model;

public class Flight extends FlightDetails {
	private Ticket[] tickets;

	public Flight(Date dateDeparture, Date dateArrival, AbstractPlaces origin, AbstractPlaces destination,
			AbstractTime timeDeparture, AbstractTime timeArrival, double price, int numberOfTicketsLeft,
			int nrOfTickets) {
		super(dateDeparture, dateArrival, origin, destination, timeDeparture, timeArrival, price, numberOfTicketsLeft);
		tickets = new Ticket[nrOfTickets];
	}

	public Ticket[] getTicket() {
		return tickets;
	}

	public void setTicket(Ticket[] tickets) {
		this.tickets = tickets;
	}

	public void addTickets(int add) {
		Ticket[] copy = new Ticket[tickets.length + add];
		for (int i = 0; i < tickets.length; i++)
			copy[i] = tickets[i];
		tickets = copy;
	}

	public void bookTicket(int counter) {
		tickets[counter].Book();
	}
}
