package ZAir.domain.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonHandler implements ActionListener
{

   private FlightGui gui;

   public ButtonHandler(FlightGui gui)
   {
      this.gui = gui;
   }

   @Override
   public void actionPerformed(ActionEvent e)
   {
      if (((JButton) e.getSource()).getText().startsWith("log"))
      {
         gui.switchPanelTo("flight-panel");
      }
      else if (((JButton) e.getSource()).getText().startsWith("Add"))
      {
         gui.switchPanelTo("add-flight");
      }
   }

}
