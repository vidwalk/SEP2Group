package Domain.Model;

import java.io.Serializable;

public abstract class AbstractPreference implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String eventType;
	private String name;

	public AbstractPreference(String name) {
		this.name = name;
		setEventType(); // we create a preference using the name of it and the event type attached to it
		// which is checked by the method
	}
	public AbstractPreference()
	{

	}
	public void setEventType() {
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

	public void setName(String name) {
		this.name = name;
	}

	public String getEventType() {
		return eventType;
	}

	public String toString() {
		return "type of preference " + name + " and event type " + eventType;
	}
}
