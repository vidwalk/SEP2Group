package ZAir.domain.model;

public class Flight {

	private Ticket[] tickets;

	private FlightDetails flightDetails;

	public Flight(int ticketsNr, FlightDetails flightDetails)
	{
		tickets = new Ticket[ticketsNr];
		this.flightDetails = flightDetails;
	}

	public Ticket[] getTicket() {
		return tickets;
	}

	public void setTicket(Ticket[] tickets) {
		this.tickets = tickets;
	}

	public FlightDetails getFlightDetails() {
		return flightDetails;
	}

	public void setFlightDetails(FlightDetails flightDetails) {
		this.flightDetails = flightDetails;
	}

	public void addTickets(int add)
	{
		Ticket[] copy = new Ticket[tickets.length + add];
		for (int i = 0; i < tickets.length; i++)
			copy[i] = tickets[i];
		tickets = copy;
	}

	public void bookTicket(int counter)
	{
		tickets[counter].Book();
	}
}
