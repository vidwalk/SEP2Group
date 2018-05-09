package ZAir.domain.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class FlightList {

	private ArrayList<Flight> flights;
	private Calendar currentDate = GregorianCalendar.getInstance();

	public FlightList() {
		flights = new ArrayList<Flight>();
	}

	public void addFlight(Flight flight) {
		flights.add(flight);
	}

	public void removeFlight(int index) {
		flights.remove(index);
	}

	public Flight[] getTodayFlights() {
		Flight[] result = new Flight[flights.size()];
		int count = 0;
		for (int i = 0; i < flights.size(); i++)
			if (flights.get(i).getDateArrival().getDay() == currentDate.get(Calendar.DAY_OF_MONTH)) {
				result[count] = flights.get(i);
				count++;
			}
		return result;
	}
}
