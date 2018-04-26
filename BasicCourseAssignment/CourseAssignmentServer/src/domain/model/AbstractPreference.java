package domain.model;

import java.io.Serializable;

public abstract class AbstractPreference implements Serializable {

	private String eventType;
	private String name;

	public AbstractPreference(String name) {
		this.name = name;
		setEventType(); // we create a preference using the name of it and the event type attached to it
		// which is checked by the method
	}

	private void setEventType() {
		if (name.equals("Astrology"))
			eventType = "Astrology Event";
		else if (name.equals("Yoga"))
			eventType = "Yoga Event";
		else if (name.equals("Trips"))
			eventType = "Trips";
		else if (name.equals("Meditation"))
			eventType = "Meditation Event";
		else if (name.equals("Workshop"))
			eventType = "Workshop Event";
		else if (name.equals("Reincarnation"))
			eventType = "Reincarnation Event";
		else if (name.equals("Karma"))
			eventType = "Karma Event";
		else if (name.equals("Alternative Health Care"))
			eventType = "Alternative Health Care Event";
	}

	public String getName() {
		return name;
	}
	
	public String getEventType()
	{
	   return eventType;
	}

	public String toString() { //make it look better
		return "type of preference " + name + " and event type " + eventType;
	}
}
