package zair.domain.model;

public abstract class AbstractPlaces
{
   private String city;
   private String country;
   private String initials;

   public AbstractPlaces(String city)
   {
      this.city = Character.toUpperCase(city.charAt(0)) + city.substring(1).toLowerCase();
      setLocation();
   }

   public String getLocation()
   {
      return city + ", " + initials + ", " + country;
   }

   public String getInitials()
   {
      return initials;
   }

   private void setLocation()
   {
      if (city.equals("Copenhagen"))
      {
         country = "Denmark";
         initials = "CPH";
      }
      else if (city.equals("Bucharest"))
      {
         country = "Romania";
         initials = "BUC";
      }
      else if (city.equals("London"))
      {
         country = "United Kingdom";
         initials = "LON";
      }
      else if (city.equals("Warsaw"))
      {
         country = "Poland";
         initials = "WAR";
      }
      else if (city.equals("Riga"))
      {
         country = "Latvia";
         initials = "RIG";
      }
      else if (city.equals("Frankfurt"))
      {
         country = "Germany";
         initials = "FRA";
      }
      else if (city.equals("Madrid"))
      {
         country = "Spain";
         initials = "MAD";
      }
      //add more
   }
}
