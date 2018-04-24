package Domain.Model;

public class Preference extends AbstractPreference {

	private String name;
	private String eventType;
	public static final String[] LEGAL_NAMES = { "Astrology", "Yoga", "Trips", "Meditation", "Workshop",
			"Reincarnation", "Karma", "Alternative Health Care" }; // certain preferences

	public Preference(String name) {
		super(name);
		setEventType(); // we create a preference using the name of it and the event type attached to it
						// which is checked by the method
	}
}
