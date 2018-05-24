package zair.domain.model;

import java.io.Serializable;
import java.util.HashMap;

public class TimeFactory implements Serializable
{
   private static HashMap<String, Time> times = new HashMap<String, Time>();

   public static AbstractTime getTime(String time)
   {
      Time item = times.get(time);
      if (item == null)
      {
         item = new Time(time);
         times.put(time, item);
      }

      return item;
   }
}
