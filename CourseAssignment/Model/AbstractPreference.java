package Domain.Model;

public abstract class AbstractPreference {

	private String eventType;
	private String name;
	public AbstractPreference(String name)
	{
		this.name = name;
	}
	public void setEventType(String eventType) {

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
	public String toString()
	{
		return "type of preference " + name + " and event type " + eventType;
	}
}
