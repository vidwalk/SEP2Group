package zair.domain.model;

import java.io.Serializable;

public abstract class AbstractTime implements Serializable
{
   private int hour;
   private int minute;

   public AbstractTime(String time)
   {
      setTime(time);
   }

   private void setTime(int hour, int minute)
   {
      if (hour >= 24)
      {
      this.hour = hour % 24;
      }
      else if (hour < 0)
      {
         this.hour = -(hour % 24);
      }
      else if (hour == 0)
      {
         this.hour = 0;
      }
      else
      {
         this.hour = hour;
      }

      if (minute < 0)
      {
         this.minute = -(minute % 60);
      }
      else if (minute > 60)
      {
         this.minute = minute % 60;
      }
      else if (minute == 0)
      {
         this.minute = minute;
      }
      else if (minute == 60 || minute % 60 == 0)
      {
         this.minute = 0;
         this.hour += 1;
      }
      else
      {
         this.minute = minute;
      }
   }

   public String toString()
   {
      if (hour < 10 && minute < 10)
      {
         return "0"+hour+":"+"0"+minute;
      }
      else if (hour < 10 && minute > 10)
      {
         return "0"+hour+":"+minute;
      }
      else if (hour > 10 && minute < 10)
      {
         return hour+":"+"0"+minute;
      }
      else
      {
         return hour+":"+minute;
      }
   }

   private void setTime(String time)
   {
      if (time.equals("8:00"))
      {
         setTime(8, 0);
      }
      else if (time.equals("10:45"))
      {
         setTime(10, 45);
      }
      else if (time.equals("14:40"))
      {
         setTime(14, 40);
      }
      else if (time.equals("20:45"))
      {
         setTime(20, 45);
      }
   }
}
