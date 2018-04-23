package Domain.Model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Log {

	private Date date;
	private static Log instance;
	public String getTimestamp() { //use this to get the present time when you add a member
		date = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return sdf.format(date);
	}
	public static Log getInstance() // singleton
	{
		if(instance == null)
			instance = new Log();
		return instance;
	}
}