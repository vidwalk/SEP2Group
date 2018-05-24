package zair.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import zair.controller.CustomerController;

public class ButtonHandler implements ActionListener
{
   private CustomerGUI gui;
   private CustomerController controller;
   
   public ButtonHandler(CustomerGUI gui, CustomerController controller)
   {
      this.gui = gui;
      this.controller = controller;
   }

   @Override
   public void actionPerformed(ActionEvent e)
   {
      if (((JButton) e.getSource()).getText().startsWith("Book"))
      {
         controller.execute("bookPanel");
      }
      else if (((JButton) e.getSource()).getText().startsWith("Search"))
      {
         controller.execute("search");
      }
      else if (((JButton) e.getSource()).getText().startsWith("Cheap"))
      {
         controller.execute("cheapFlights");
      }
      else if (((JButton) e.getSource()).getText().startsWith("Confirm"))
      {
         controller.execute("confirmation");
      }
      else if (((JButton) e.getSource()).getText().startsWith("Back"))
      {
         controller.execute("back");
      }
      else if (((JButton) e.getSource()).getText().startsWith("Log in"))
      {
         controller.execute("logIn");
      }
      else if (((JButton) e.getSource()).getText().startsWith("Sign up"))
      {
         controller.execute("signUp");
      }
      else if (((JButton) e.getSource()).getText().startsWith("Register"))
      {
         controller.execute("register");
      }
   }
   
}
