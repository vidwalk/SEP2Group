package zair.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import zair.controller.FlightController;

public class ButtonHandler implements ActionListener
{
   private FlightController controller;
   private FlightGUI gui;
   
   public ButtonHandler(FlightController controller, FlightGUI gui)
   {
      this.controller = controller;
      this.gui = gui;
   }

   @Override
   public void actionPerformed(ActionEvent e)
   {
      if (((JButton) e.getSource()).getText().startsWith("Add"))
      {
         controller.execute("add");
      }
      else if (((JButton) e.getSource()).getText().startsWith("Save flight"))
      {
         controller.execute("save flight");
      }
      else if (((JButton) e.getSource()).getText().startsWith("Back"))
      {
         controller.execute("back from add flight");
      }
      else if (((JButton) e.getSource()).getText().startsWith("Status"))
      {
         controller.execute("status panel");
      }
      else if (((JButton) e.getSource()).getText().startsWith("Remove flight"))
      {
         controller.execute("remove-flight");
      }
      else if (((JButton) e.getSource()).getText().startsWith("OK"))
      {
         controller.execute("search flight");
      }
      else if (((JButton) e.getSource()).getText().startsWith("Reset view"))
      {
         controller.execute("reset view");
      }
   }
   
   
}
