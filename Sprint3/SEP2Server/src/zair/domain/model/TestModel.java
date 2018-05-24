package zair.domain.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestModel {
	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void test() {
		Date dateOfArrival = new Date(10, 12, 2018);
		Date dateOfDeparture = new Date(12, 12, 2018);
		Flight flight = new Flight(dateOfArrival, dateOfDeparture, PlacesFactory.getPlace("Copenhagen").getLocation(),
				PlacesFactory.getPlace("Bucharest").getLocation(), TimeFactory.getTime("10:00").toString(),
				TimeFactory.getTime("12:00").toString(), 500);
		Flight flight1 = new Flight(dateOfArrival, dateOfDeparture, PlacesFactory.getPlace("Bucharest").getLocation(),
				PlacesFactory.getPlace("Copenhagen").getLocation(), TimeFactory.getTime("10:00").toString(),
				TimeFactory.getTime("12:00").toString(), 500);
		Flight flight2 = new Flight(dateOfArrival, dateOfDeparture, PlacesFactory.getPlace("Bucharest").getLocation(),
				PlacesFactory.getPlace("Copenhagen").getLocation(), TimeFactory.getTime("10:00").toString(),
				TimeFactory.getTime("12:00").toString(), 500);
		if (flight.equals(flight1))
			fail("Flights are null or constructed in a wrong way");
		System.out.println(flight);
		System.out.println(flight1);
		if (PlacesFactory.getPlace("Bucharest").equals(PlacesFactory.getPlace("Copenhagen")))
			fail("Places are null or created in the wrong way");
		assertEquals(flight1.getOrigin(), flight2.getOrigin());
		assertEquals(flight1.getDateArrival(),flight2.getDateArrival());
		assertEquals(flight1.getTimeArrival(), flight2.getTimeArrival());
		assertEquals(Log.getInstance().getTimestamp(), Log.getInstance().getTimestamp());
		System.out.println(Log.getInstance().getTimestamp());
	}

	@After
	public void tearDown() throws Exception {
		// nothing
	}
}
