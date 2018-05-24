package zair.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
import zair.domain.model.MyNumericValidator;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

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
   private JButton[] buttons;
   private JList<String> flightList;
   private JLabel[] labels;
   private JComboBox[] comboBoxes;
   private JTextField[] fields;
   private JDateChooser dateChooser;
   private JDateChooser dateChooser_1;
   private JTextArea textArea;
   private JScrollPane pane;
   private JTable flights;
   private FlightController controller;
   private ButtonHandler listener;
   private String[] locations = new String[] {"Copenhagen", "Bucharest", "London", "Warsaw", "Riga", "Frankfurt", "Madrid"};
   private String[] times = new String[] {"8:00", "10:45", "14:40", "20:45"};
   
   public FlightGUI() 
   {
      super("Server");
      controller = null;
      buttons = new JButton[9];
      comboBoxes = new JComboBox[4];
      labels = new JLabel[12];
      fields = new JTextField[2];
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
      Object rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3", "Row1-Column4", "Row1-Column5", "Row1-Column6", "Row1-Column7"},
            { "Row2-Column1", "Row2-Column2", "Row2-Column3", "Row2-Column4", "Row2-Column5", "Row2-Column6", "Row2-Column7"}};
      Object columnNames[] = { "Flight id", "Origin", "Destination", "Date", "Time", "Price", "Tickets left"};
      flights = new JTable(rowData, columnNames);
      flightPanel.add(panel_2, BorderLayout.CENTER);
      panel_2.setLayout(null);
      pane.setBounds(32, 60, 1202, 566);
      pane.setViewportView(flights);
      panel_2.add(pane);
      buttons[2].setBounds(46, 638, 117, 29);
      panel_2.add(buttons[2]);
      buttons[3].setBounds(175, 638, 117, 29);
      panel_2.add(buttons[3]);
      labels[1].setBounds(51, 10, 230, 38);
      panel_2.add(labels[1]);
      fields[0].setBounds(370, 27, 130, 18);
      panel_2.add(fields[0]);
      labels[3].setBounds(304, 28, 61, 16);
      panel_2.add(labels[3]);
      buttons[4].setBounds(512, 23, 43, 25);
      panel_2.add(buttons[4]);
      buttons[7].setBounds(427, 638, 117, 29);
      panel_2.add(buttons[7]);
      buttons[8].setBounds(301, 640, 114, 25);
      panel_2.add(buttons[8]);
      mainPanel.add(flightPanel, "flight-panel");  //name for flightPanel for CardLayout
      //finished flight panel
      
      // add flight panel
      addFlightPanel.setBounds(100, 100, 450, 300);
      addFlightPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
      addFlightPanel.setLayout(null);
      labels[4].setBounds(27, 6, 139, 24);
      addFlightPanel.add(labels[4]);
      labels[5].setBounds(73, 79, 43, 16);
      addFlightPanel.add(labels[5]);
      comboBoxes[0].setBounds(128, 75, 149, 27);
      addFlightPanel.add(comboBoxes[0]);
      labels[6].setBounds(39, 121, 77, 16);
      addFlightPanel.add(labels[6]);
      comboBoxes[1].setBounds(128, 114, 149, 27);
      addFlightPanel.add(comboBoxes[1]);
      labels[7].setBounds(39, 183, 111, 16);
      addFlightPanel.add(labels[7]);
      labels[8].setBounds(73, 221, 78, 16);
      addFlightPanel.add(labels[8]);
      labels[9].setBounds(49, 284, 101, 16);
      addFlightPanel.add(labels[9]);
      labels[10].setBounds(73, 317, 80, 16);
      addFlightPanel.add(labels[10]);
      labels[11].setBounds(363, 79, 34, 16);
      addFlightPanel.add(labels[11]);
      fields[1].setBounds(408, 74, 130, 26);
      addFlightPanel.add(fields[1]);
      dateChooser.setBounds(162, 178, 131, 26);
      addFlightPanel.add(dateChooser);
      dateChooser_1.setBounds(162, 211, 131, 26);
      addFlightPanel.add(dateChooser_1);
      comboBoxes[2].setBounds(162, 280, 111, 27);
      addFlightPanel.add(comboBoxes[2]);
      comboBoxes[3].setBounds(165, 313, 108, 27);
      addFlightPanel.add(comboBoxes[3]);
      buttons[5].setBounds(346, 326, 111, 29);
      addFlightPanel.add(buttons[5]);
      buttons[6].setBounds(469, 326, 75, 29);
      addFlightPanel.add(buttons[6]);
      mainPanel.add(addFlightPanel, "add-flight");  //name for addFlightPanel for CardLayout
      //finished add flight panel
      
   // status panel
      statusPanel.setBounds(100, 100, 450, 300);
      statusPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
      statusPanel.setLayout(null);
      statusPanel.add(labels[0]);
      labels[0].setBounds(75, 50, 100, 16);
      textArea.setBounds(75, 100, 1132, 502);
      statusPanel.add(textArea);
      buttons[0].setBounds(68, 627, 117, 29);
      statusPanel.add(buttons[0]);
      buttons[1].setBounds(197, 627, 117, 29);
      statusPanel.add(buttons[1]);
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
      JTextFieldDateEditor editor = (JTextFieldDateEditor) dateChooser.getDateEditor();
      editor.setEditable(false);
      JTextFieldDateEditor editor1 = (JTextFieldDateEditor) dateChooser_1.getDateEditor();
      editor1.setEditable(false);
      buttons[0] = new JButton("Save");
      buttons[1] = new JButton("Back");
      buttons[2] = new JButton("Add");
      buttons[3] = new JButton("Remove flight");
      buttons[4] = new JButton("OK");
      buttons[5] = new JButton("Save flight");
      buttons[6] = new JButton("Back");
      buttons[7] = new JButton("Status");
      buttons[8] = new JButton("Reset view");
      labels[0] = new JLabel("Console:");
      labels[1] = new JLabel("Flights: ");
      labels[0].setFont(new Font("Lucida Grande", Font.PLAIN, 20));
      labels[1].setFont(new Font("Lucida Grande", Font.PLAIN, 32));
      labels[3] = new JLabel("Search:");
      labels[4] = new JLabel("Add flight:");
      labels[4].setFont(new Font("Lucida Grande", Font.PLAIN, 20));
      labels[5] = new JLabel("Origin:");
      labels[6] = new JLabel("Destination:");
      labels[7] = new JLabel("Departure Date:");
      labels[8] = new JLabel("Arrival Date:");
      labels[9] = new JLabel("Departure Time:");
      labels[10] = new JLabel("Arrival Time:");
      labels[11] = new JLabel("Price:");
      fields[0] = new JTextField();
      fields[0].setColumns(10);
      fields[0].setName("searchTextField");
      fields[1] = new JTextField();
      fields[1].setColumns(10);
      fields[1].setName("price");
      fields[1].setInputVerifier(MyNumericValidator.getInstance());
      comboBoxes[0] = new JComboBox<>();
      comboBoxes[1] = new JComboBox<>();
      comboBoxes[2] = new JComboBox<>();
      comboBoxes[3] = new JComboBox<>();
      comboBoxes[0].setModel(new DefaultComboBoxModel<>(locations));
      comboBoxes[1].setModel(new DefaultComboBoxModel<>(locations));
      comboBoxes[2].setModel(new DefaultComboBoxModel<>(times));
      comboBoxes[3].setModel(new DefaultComboBoxModel<>(times));
      comboBoxes[0].setName("origin");
      comboBoxes[1].setName("destination");
      comboBoxes[2].setName("departure");
      comboBoxes[3].setName("arrival");
      pane = new JScrollPane();
   }

   @Override
   public void startController(FlightController controller)
   {
      this.controller = controller;
      listener = new ButtonHandler(controller, this);
      for (int i = 0; i < buttons.length; i++)
      {
         buttons[i].addActionListener(listener);
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
   
   public String getTextFieldInput(String name)
   {
      String output = "";
      for (int i = 0; i < fields.length; i++)
      {
         if (fields[i].getName().equals(name))
         {
            output = fields[i].getText();
         }
      }
      return output;
   }
   
   public String getComboBoxItem(String name)
   {
      String output = "";
      for (int i = 0; i < comboBoxes.length; i++)
      {
         if (comboBoxes[i].getName().equals(name))
         {
            output = (String) comboBoxes[i].getSelectedItem();
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
      String[] columnNames = { "Flight id", "Origin", "Destination", "Date", "Time", "Price", "Tickets left"};
      DefaultTableModel model = new DefaultTableModel(columnNames, 0);
      for (int i = 0; i < flights.length; i++)
      {
         String[] array = flights[i].split("<");
         model.addRow(array);
      }
      this.flights.setModel(model);
   }

   @Override
   public void update(Observable o, Object arg)
   {
      showText((String) arg);
   }

   @Override
   public String getDates(String what)
   {
      String output = "";
      LocalDate localDate = null;
      if (dateChooser.getName().equals(what))
      {
         localDate = dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
         output = localDate.getDayOfMonth() + "/" + localDate.getMonthValue() + "/" + localDate.getYear();
      }
      else if (dateChooser_1.getName().equals(what))
      {
         localDate = dateChooser_1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
         output = localDate.getDayOfMonth() + "/" + localDate.getMonthValue() + "/" + localDate.getYear();
      }
      
      return output;
   }

   @Override
   public int getSelectedIndex()
   {
      return flights.getSelectedRow();
   }
   
   @Override
   public boolean isRowSelected()
   {
      if (flights.getSelectionModel().isSelectionEmpty())
      {
         return false;
      }
      else
      {
         return true;
      }
   }
}
