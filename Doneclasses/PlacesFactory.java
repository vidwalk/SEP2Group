package model;
import java.util.HashMap;

public class PlacesFactory
{
   private static HashMap<String, Places> places = new HashMap<String, Places>();
   
   public static AbstractPlaces getPlace(String city)
   {
      Places item = places.get(city);
      if (item == null)
      {
         item = new Places(city);
         places.put(city, item);
      }
      
      return item;
   }
   
}
