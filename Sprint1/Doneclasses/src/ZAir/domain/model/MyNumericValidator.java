package zair.domain.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
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
      String text = ((JTextField) input).getText();
      return false;
   }
   
}
