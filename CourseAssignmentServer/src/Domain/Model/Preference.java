package Domain.Model;

public class Preference extends AbstractPreference {

	public static final String[] LEGAL_NAMES = { "Astrology", "Yoga", "Trips", "Meditation", "Workshop",
			"Reincarnation", "Karma", "Alternative Health Care" }; // certain preferences

	public Preference(String name) {
		super(name);

	}
}
