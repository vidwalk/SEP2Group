package Domain.Model;

import java.io.Serializable;

public class Preference extends AbstractPreference implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public static final String[] LEGAL_NAMES = { "Astrology", "Yoga", "Trips", "Meditation", "Workshop",
			"Reincarnation", "Karma", "Alternative Health Care" }; // certain preferences

	public Preference(String name) {
		super(name);

	}
	public Preference()
	{

	}
}
