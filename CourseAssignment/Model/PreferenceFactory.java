package Domain.Model;

public class PreferenceFactory {

	private AbstractPreference[] abstractPreference = new AbstractPreference[8];

public String getPreference(String name) //use to get a certain preference
{
	for(int i = 0; i < abstractPreference.length; i++)
		if(abstractPreference[i].getName().equals(name))
			return abstractPreference[i].getName();
	return "no such preference";
}
}
