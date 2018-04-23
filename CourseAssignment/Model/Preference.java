package Domain.Model;
public class Preference extends AbstractPreference {

	private String name;
	private String eventType;
	public static final String[] LEGAL_NAMES = { "Astrology", "Yoga", "Trips", "Meditation", "Workshop",
			"Reincarnation", "Karma", "Alternative Health Care" }; // certain preferences

	public Preference(String name) {
		super(name);
		setEventType(); //we create a preference using the name of it and the event type attached to it which is checked by the method
	}
	public void setEventType() {
		if(name.equals("Astrology"))
			eventType = "Astrology Event";
		else if(name.equals("Yoga"))
			eventType = "Yoga Event";
		else if(name.equals("Trips"))
			eventType = "Trips";
		else if(name.equals("Meditation"))
			eventType = "Meditation Event";
		else if(name.equals("Workshop"))
			eventType = "Workshop Event";
		else if(name.equals("Reincarnation"))
			eventType = "Reincarnation Event";
		else if(name.equals("Karma"))
			eventType = "Karma Event";
		else if(name.equals("Alternative Health Care"))
			eventType = "Alternative Health Care Event";
	}
}
