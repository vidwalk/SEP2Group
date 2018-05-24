package zair.domain.model;

import java.io.Serializable;

public class Credentials implements Serializable
{
   private String userId;
   private String password;
   
   public Credentials(String userId, String password)
   {
      this.userId = userId;
      this.password = password;
   }
   
   public String getUserId()
   {
      return userId;
   }
   
   public String getPassword()
   {
      return password;
   }
}
