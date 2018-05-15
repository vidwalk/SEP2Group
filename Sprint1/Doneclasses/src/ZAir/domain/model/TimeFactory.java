package zair.domain.model;

import java.util.HashMap;

public class TimeFactory {
	private static HashMap<String, AbstractTime> times = new HashMap<String, AbstractTime>();

	public static AbstractTime getTime(String time) {
		AbstractTime item = times.get(time);
		if (item == null) {
			item = new Time(time);
			times.put(time, item);
		}

		return item;
	}
}
