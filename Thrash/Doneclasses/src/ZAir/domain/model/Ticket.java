package ZAir.domain.model;

import java.util.UUID;

public class Ticket {

	private Seat seat;
	private String ticketID;
	private FlightDetails flight;
	public Ticket(Seat seat, FlightDetails flight) {
		this.flight = flight;
		this.seat = seat;
		ticketID = UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	public void Book() {
		seat.Book();
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public String getTicketID() {
		return ticketID;
	}

	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}

}
