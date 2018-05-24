package zair.domain.model;

import java.util.UUID;

public class Ticket {
   private String seatNumber;
	private String ticketID;
	private double price;
	private Flight flight;

	public Ticket(int index, Flight flight) {
		this.flight = flight;
		Seat seat = flight.getAvailableSeats()[index];
		flight.setSeatOccupied(seat);
		seatNumber = getSeat(index);
		ticketID = UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	private String getSeat(int index) {
		return flight.getAllSeats()[index].toString();
	}
	
	public String getSeatNumber()
	{
	   return seatNumber;
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
	
	public Flight getFlight()
	{
	   return flight;
	}

}
