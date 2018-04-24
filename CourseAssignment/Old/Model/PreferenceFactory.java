package Domain.Model;

import java.util.HashMap;

public class PreferenceFactory {

	private static HashMap<String, Preference> preferences = new HashMap<String, Preference>();

public static AbstractPreference getPreference(String name) //use to get a certain preference
{
	Preference item = preferences.get(name);
    if (item == null)
    {
       item = new Preference(name);
       preferences.put(name, item);
    }

    return item;
}
}
