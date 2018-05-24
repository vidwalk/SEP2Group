package zair.domain.model;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Log implements Serializable{

	private static Log instance;
	
	private Log()
	{
		//
	}
	
	public String getTimestamp() { //use this to get the present time when you add a member
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return sdf.format(Calendar.getInstance().getTime());
	}
	
	public static Log getInstance() // singleton
	{
		if(instance == null)
			instance = new Log();
		return instance;
	}
}
