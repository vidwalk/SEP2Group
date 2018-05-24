package zair.domain.model;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyNumericValidator extends InputVerifier
{

   private static MyNumericValidator instance;
   
   private MyNumericValidator()
   {
      //
   }
   
   public static MyNumericValidator getInstance()
   {
      if (instance == null)
      {
      instance = new MyNumericValidator();
      }
      return instance;
   }
   
   @Override
   public boolean verify(JComponent input)
   {
      boolean valid = true;
      String text = ((JTextField) input).getText();
      try
      {
         Double.parseDouble(text);
      }
      catch (NumberFormatException e)
      {
         valid = false;
         JOptionPane.showMessageDialog(null, "Price has to be a number! No other characters are allowed.");
      }
      
      return valid;
   }
   
   
   
}
