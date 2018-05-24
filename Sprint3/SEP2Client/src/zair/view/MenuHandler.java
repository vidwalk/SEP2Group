package zair.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import zair.controller.CustomerController;

public class MenuHandler implements ActionListener
{
   
   private CustomerGUI gui;
   private CustomerController controller;
   
   public MenuHandler(CustomerGUI gui, CustomerController controller)
   {
      this.gui = gui;
      this.controller = controller;
   }

   @Override
   public void actionPerformed(ActionEvent e)
   {
      if (((JMenuItem) e.getSource()).getText().startsWith("View profile"))
      {
         controller.execute("viewProfile");
      }
      if (((JMenuItem) e.getSource()).getText().startsWith("Sign out"))
      {
         controller.execute("signOut");
      }
   }
   
}
