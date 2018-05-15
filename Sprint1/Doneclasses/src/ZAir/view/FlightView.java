package zair.view;

import java.util.Observer;

import zair.controller.FlightController;

public interface FlightView extends Observer
{
   void startController(FlightController controller);
   void showIp(String number);
   void showText(String what);
   void switchPanelTo(String panel);
   String get(String what);
   void launchOption(String messageType);
   void loadFlights(String[] flights);
   String getTextFieldInput(String name);
   String getComboBoxIndex(String name);
}
