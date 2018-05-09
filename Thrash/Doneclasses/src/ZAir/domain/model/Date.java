package ZAir.domain.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date
{
   private int day;
   private int month;
   private int year;

   public int getDay() {
	return day;
}

public void setDay(int day) {
	this.day = day;
}

public int getMonth() {
	return month;
}

public void setMonth(int month) {
	this.month = month;
}

public int getYear() {
	return year;
}

public void setYear(int year) {
	this.year = year;
}

public Date(int day, int month, int year)
   {
      setDate(day, month, year);
   }

   public Date()
   {
      Calendar currentDate = GregorianCalendar.getInstance();
      day = currentDate.get(Calendar.DAY_OF_MONTH);
      month = (currentDate.get(Calendar.MONTH) + 1);
      year = currentDate.get(Calendar.YEAR);
   }

   public void setDate(int day, int month, int year)
   {
      if (year < 0)
      {
         this.year = -year;
      }
      else
      {
         this.year = year;
      }

      if (month < 1)
      {
         this.month = 1;
      }

      else if (month > 12)
      {
         this.month = 12;
      }
      else
      {
         this.month = month;
      }

      if (day < 1)
      {
         this.day = 1;
      }

      else if (day > numberOfDaysInMonth())
      {
        this.day = numberOfDaysInMonth();
      }
      else
      {
         this.day = day;
      }
   }

   private boolean isLeapYear()
   {
      if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
      {
         return true;

      }

      else
      {
         return false;
      }
   }

   public String getDayOfTheWeek()
   {
      java.util.Date dateToConvert = new java.util.Date(year-1900, month-1, day);
      String output = new SimpleDateFormat("EE").format(dateToConvert);
      return output;
   }

   private int numberOfDaysInMonth()
   {
      if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10
      || month == 12)

      {
         return 31;
      }

      if(month == 4 || month == 6 || month == 9 || month == 11)

      {
         return 30;
      }

      if(isLeapYear() == true)
      {
         return 29;
      }

      else
      {
         return 28;
      }
   }

   public String toString()
   {
      if (day < 10 && month < 10)
      {
         return "0" + day + "/0" + month + "/" + year;
      }
      else if (day < 10)
      {
         return "0" + day + "/" + month + "/" + year;
      }
      else if (month < 10)
      {
         return day + "/0" + month + "/" + year;
      }
      else
      {
         return day + "/" + month + "/" + year;
      }
   }
}
