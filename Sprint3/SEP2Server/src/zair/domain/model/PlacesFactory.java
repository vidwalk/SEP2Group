package zair.domain.model;

import java.io.Serializable;
import java.util.HashMap;

public class PlacesFactory implements Serializable
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
