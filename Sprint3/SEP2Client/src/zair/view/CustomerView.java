package zair.view;

import zair.controller.CustomerController;

public interface CustomerView
{
   void startController(CustomerController controller);
   void switchPanelTo(String panel);
   void launchOption(String messageType);
   String getComboBoxItem(String name);
   int getSelectedIndex(String name);
   void loadFlights(String[] flight);
   void loadCustomer(String customerDetails, String[] tickets);
   void loadSpecificFlight(String flightDetails, String[] seats);
   boolean isRowSelected(String name);
   String getTextFieldInput(String name);
}
