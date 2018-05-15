package zair.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Observable;

import zair.controller.FlightController;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class FlightGUI extends JFrame implements FlightView
{
   private JPanel mainPanel; 
   private JPanel flightPanel;
   private JPanel addFlightPanel;
   private JPanel statusPanel;
   private ArrayList<JButton> buttons;
   private JList<String> flightList;
   private ArrayList<JLabel> labels;
   private ArrayList<JComboBox<String>> comboBoxes;
   private ArrayList<JTextField> fields;
   private JDateChooser dateChooser;
   private JDateChooser dateChooser_1;
   private JTextArea textArea;
   
   private JButton btnAdd;
   private JButton btnRemove;
   private JLabel lblFlights;
   private JButton btnExit1;
   private JTextField searchTextField;
   private JLabel lblSearch;
   private JButton btnOk;
   private JLabel lblAddFlight;
   private JLabel lblOrigin;
   private JComboBox comboBox;
   private JLabel lblDestination;
   private JComboBox comboBox_1;
   private JLabel lblDeparturedDate;
   private JLabel lblArrivalDate;
   private JLabel lblDepartureTime;
   private JLabel lblArrivalTime;
   private JLabel lblPrice;
   private JTextField textField_2;
   private JComboBox<String> comboBox_2;
   private JComboBox<String> comboBox_3;
   private JButton btnSave;
   private JButton btnBack;
   private JLabel lblIp;
   private JButton btnNewButton;
   private JButton btnExit;
   private FlightController controller;
   private ButtonHandler listener;
   private JButton btnStatus;
   private JButton resetView;
   private String[] locations = new String[] {"Copenhagen", "Bucharest", "London", "Warsaw", "Riga", "Frankfurt", "Madrid"};
   private String[] times = new String[] {"8:00", "10:45", "14:40", "20:45"};
   
   public FlightGUI() 
   {
      super("Server");
      controller = null;
      createComponents();
      initializeComponents();
      addComponentsToFrame();
   }

   private void addComponentsToFrame()
   {
   // flight panel
      flightPanel.setBounds(100, 100, 450, 300);
      flightPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
      flightPanel.setLayout(new BorderLayout(0, 0));
      JPanel panel_2 = new JPanel();
      flightPanel.add(panel_2, BorderLayout.CENTER);
      panel_2.setLayout(null);
      flightList.setBounds(32, 60, 1202, 566);
      panel_2.add(flightList);
      buttons.get(2).setBounds(46, 638, 117, 29);
      panel_2.add(buttons.get(2));
      buttons.get(3).setBounds(175, 638, 117, 29);
      panel_2.add(buttons.get(3));
      labels.get(1).setBounds(51, 10, 230, 38);
      panel_2.add(labels.get(1));
      fields.get(0).setBounds(370, 27, 130, 18);
      panel_2.add(fields.get(0));
      labels.get(3).setBounds(304, 28, 61, 16);
      panel_2.add(labels.get(3));
      buttons.get(4).setBounds(512, 23, 43, 25);
      panel_2.add(buttons.get(4));
      buttons.get(7).setBounds(427, 638, 117, 29);
      panel_2.add(buttons.get(7));
      buttons.get(8).setBounds(301, 640, 114, 25);
      panel_2.add(buttons.get(8));
      mainPanel.add(flightPanel, "flight-panel");  //name for flightPanel for CardLayout
      //finished flight panel
      
      // add flight panel
      addFlightPanel.setBounds(100, 100, 450, 300);
      addFlightPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
      addFlightPanel.setLayout(null);
      labels.get(4).setBounds(27, 6, 139, 24);
      addFlightPanel.add(labels.get(4));
      labels.get(5).setBounds(73, 79, 43, 16);
      addFlightPanel.add(labels.get(5));
      comboBox.setBounds(128, 75, 149, 27);
      addFlightPanel.add(comboBox);
      labels.get(6).setBounds(39, 121, 77, 16);
      addFlightPanel.add(labels.get(6));
      comboBox_1.setBounds(128, 114, 149, 27);
      addFlightPanel.add(comboBox_1);
      labels.get(7).setBounds(39, 183, 111, 16);
      addFlightPanel.add(labels.get(7));
      labels.get(8).setBounds(73, 221, 78, 16);
      addFlightPanel.add(labels.get(8));
      labels.get(9).setBounds(49, 284, 101, 16);
      addFlightPanel.add(labels.get(9));
      labels.get(10).setBounds(73, 317, 80, 16);
      addFlightPanel.add(labels.get(10));
      labels.get(11).setBounds(363, 79, 34, 16);
      addFlightPanel.add(lblPrice);
      textField_2.setBounds(408, 74, 130, 26);
      addFlightPanel.add(textField_2);
      dateChooser.setBounds(162, 178, 131, 26);
      addFlightPanel.add(dateChooser);
      dateChooser_1.setBounds(162, 211, 131, 26);
      addFlightPanel.add(dateChooser_1);
      comboBox_2.setBounds(162, 280, 111, 27);
      addFlightPanel.add(comboBox_2);
      comboBox_3.setBounds(165, 313, 108, 27);
      addFlightPanel.add(comboBox_3);
      btnSave.setBounds(346, 326, 111, 29);
      addFlightPanel.add(btnSave);
      btnBack.setBounds(469, 326, 75, 29);
      addFlightPanel.add(btnBack);
      mainPanel.add(addFlightPanel, "add-flight");  //name for addFlightPanel for CardLayout
      //finished add flight panel
      
   // status panel
      statusPanel.setBounds(100, 100, 450, 300);
      statusPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
      statusPanel.setLayout(null);
      statusPanel.add(labels.get(0));
      labels.get(0).setBounds(75, 50, 61, 16);
      textArea.setBounds(75, 100, 1132, 502);
      statusPanel.add(textArea);
      buttons.get(0).setBounds(68, 627, 117, 29);
      statusPanel.add(buttons.get(0));
      buttons.get(1).setBounds(197, 627, 117, 29);
      statusPanel.add(buttons.get(1));
      mainPanel.add(statusPanel, "status-panel"); //name for statusPanel for CardLayout
   // finished status panel
      
      // sets contentPane
      setContentPane(mainPanel);
      //sets ContentPane
   }

   private void initializeComponents()
   {
      setSize(1280, 720); // set frame size
      setLocationRelativeTo(null); // center of the screen
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   private void createComponents()
   {   
      mainPanel = new JPanel(new CardLayout());
      addFlightPanel = new JPanel();
      statusPanel = new JPanel();
      textArea = new JTextArea();
      flightList = new JList<>();
      flightList.setFont(new Font("Arial", Font.BOLD,16));
      flightList.setFixedCellHeight(40);
      flightPanel = new JPanel();
      dateChooser = new JDateChooser();
      dateChooser.setName("departure_date");
      dateChooser_1 = new JDateChooser();
      dateChooser_1.setName("arrival_date");
      buttons = new ArrayList<JButton>();
      comboBoxes = new ArrayList<JComboBox<String>>();
      labels = new ArrayList<JLabel>();
      fields = new ArrayList<JTextField>();
      buttons.set(0, new JButton("Save"));
      buttons.set(1, new JButton("Back"));
      buttons.set(2, new JButton("Add"));
      buttons.set(3, new JButton("Remove flight"));
      buttons.set(4, new JButton("OK"));
      buttons.set(5, new JButton("Save flight"));
      buttons.set(6, new JButton("Back"));
      buttons.set(7, new JButton("Status"));
      buttons.set(8, new JButton("Reset view"));
      labels.set(0, new JLabel("IP:"));
      labels.set(1, new JLabel("Flights: "));
      labels.get(0).setFont(new Font("Lucida Grande", Font.PLAIN, 20));
      labels.get(1).setFont(new Font("Lucida Grande", Font.PLAIN, 32));
      labels.set(3, new JLabel("Search:"));
      labels.set(4, new JLabel("Add flight:"));
      labels.get(4).setFont(new Font("Lucida Grande", Font.PLAIN, 20));
      labels.set(5, new JLabel("Origin:"));
      labels.set(6, new JLabel("Destination:"));
      labels.set(7, new JLabel("Departure Date:"));
      labels.set(8, new JLabel("Arrival Date:"));
      labels.set(9, new JLabel("Departure Time:"));
      labels.set(10, new JLabel("Arrival Time:"));
      labels.set(11, new JLabel("Price:"));
      fields.set(0, new JTextField());
      fields.get(0).setColumns(10);
      fields.get(0).setName("searchTextField");
      fields.set(1, new JTextField());
      fields.get(1).setColumns(10);
      fields.get(1).setName("price");
      comboBoxes.set(0, new JComboBox<>());
      comboBoxes.set(1, new JComboBox<>());
      comboBoxes.set(2, new JComboBox<>());
      comboBoxes.set(3, new JComboBox<>());
      comboBoxes.get(0).setModel(new DefaultComboBoxModel<>(locations));
      comboBoxes.get(1).setModel(new DefaultComboBoxModel<>(locations));
      comboBoxes.get(2).setModel(new DefaultComboBoxModel<>(times));
      comboBoxes.get(3).setModel(new DefaultComboBoxModel<>(times));
      comboBoxes.get(0).setName("origin");
      comboBoxes.get(1).setName("destination");
      comboBoxes.get(2).setName("departure");
      comboBoxes.get(3).setName("arrival");
   }

   public void showIp(String number)
   {
      lblIp.setText(number);
   }

   @Override
   public void startController(FlightController controller)
   {
      this.controller = controller;
      listener = new ButtonHandler(controller, this);
      for (int i = 0; i < buttons.size(); i++)
      {
         buttons.get(i).addActionListener(listener);
      }
      setVisible(true);
   }

   @Override
   public void showText(String what)
   {
      String old = "";
      if (textArea.getText().length() > 1)
      {
         old = textArea.getText();
         textArea.setText(old + "\n" + what);
      }
      else
      {
         textArea.setText(what);
      }
   }
   
   public void switchPanelTo(String panel)
   {
      CardLayout layout = (CardLayout) mainPanel.getLayout();
      layout.show(mainPanel, panel);
   }
   
   public String get(String what)
   {
      String output = null;
      switch (what)
      {
         case "departure_date": LocalDate localDate = dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
         output = localDate.getDayOfMonth() + "/" + localDate.getMonthValue() + "/" + localDate.getYear();
         break;
         case "arrival_date": LocalDate localDate1 = dateChooser_1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
         output = localDate1.getDayOfMonth() + "/" + localDate1.getMonthValue() + "/" + localDate1.getYear();
         break;
         case "origin": output = (String) comboBox.getSelectedItem();
         break;
         case "destination": output = (String) comboBox_1.getSelectedItem();
         break;
         case "departure_time": output = (String) comboBox_2.getSelectedItem();
         break;
         case "arrival_time": output = (String) comboBox_3.getSelectedItem();
         break;
         case "price": output = textField_2.getText();
         break;
         case "flights": 
            if (flightList.getModel().getSize() > 0)
            {
               output = "" + flightList.getSelectedIndex();
            }
         break;
         case "search":
            output = searchTextField.getText();
            break;
      }
      return output;
   }
   
   private ArrayList<Component> getAllComponents(final Container c)
   {
      Component[] components = c.getComponents();
      ArrayList<Component> list = new ArrayList<Component>();
      for (Component comp : components)
      {
         list.add(comp);
         if (comp instanceof Container)
         {
            list.addAll(getAllComponents((Container) comp));
         }
      }
      return list;
   }
   
   public String getTextFieldInput(String name)
   {
      String output = "";
      ArrayList<Component> components = getAllComponents(this);
      for (int i = 0; i < components.size(); i++)
      {
         if (components.get(i) instanceof JTextField && components.get(i).getName().equals(name))
         {
            output = ((JTextField) components.get(i)).getText();
         }
      }
      return output;
   }
   
   public String getComboBoxIndex(String name)
   {
      String output = "";
      ArrayList<Component> components = getAllComponents(this);
      for (int i = 0; i < components.size(); i++)
      {
         if (components.get(i) instanceof JComboBox && components.get(i).getName().equals(name))
         {
            output = (String) ((JComboBox) components.get(i)).getSelectedItem();
         }
      }
      return output;
   }
   
   @Override
   public void launchOption(String messageType)
   {
      JOptionPane.showMessageDialog(this, messageType);
   }

   @Override
   public void loadFlights(String[] flights)
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         
         @Override
         public void run()
         {
            DefaultListModel<String> listModel = new DefaultListModel<>();
            for (int i = 0; i < flights.length; i++)
            {
               listModel.addElement(flights[i]);
            }
            flightList.setModel(listModel);
         }
      });
   }

   @Override
   public void update(Observable o, Object arg)
   {
      showText((String) arg);
   }
}
