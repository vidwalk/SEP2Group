package ZAir.domain.model;
import java.util.HashMap;

public class PlacesFactory
{
   private static HashMap<String, AbstractPlaces> places = new HashMap<String, AbstractPlaces>();

   public static AbstractPlaces getPlace(String city)
   {
	   AbstractPlaces item = places.get(city);
      if (item == null)
      {
         item = new Places(city);
         places.put(city, item);
      }

      return item;
   }

}