package ZAir.domain.model;

import java.util.UUID;

public class Ticket {

	private Seat seat;
	private String ticketID;
	private double price;

	public Ticket(Seat seat) {
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
