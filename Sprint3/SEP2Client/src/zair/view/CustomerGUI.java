package zair.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import zair.controller.CustomerController;

import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JMenu;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class CustomerGUI extends JFrame implements CustomerView
{
   private JPanel contentPane;
   private JPanel mainPanel;
   private JPanel bookPanel;
   private JPanel viewProfilePanel;
   private JPanel homePanel;
   private JPanel signUpPanel;
   private JTable[] tables;
   private JButton[] buttons;
   private JLabel[] labels;
   private JScrollPane[] scrollPanes;
   private JComboBox[] comboBoxes;
   private JTextField[] fields;
   private JMenuBar bar;
   private JMenu menu;
   private JSeparator separator;
   private JMenuItem[] items;
   private ButtonHandler handler;
   private CustomerController controller;
   private MenuHandler listener;
   private String[] locations = new String[] {"Copenhagen", "Bucharest", "London", "Warsaw", "Riga", "Frankfurt", "Madrid"};

   public CustomerGUI()
   {
      super("Client");
      tables = new JTable[3];
      fields = new JTextField[9];
      buttons = new JButton[9];
      labels = new JLabel[34];
      scrollPanes = new JScrollPane[3];
      comboBoxes = new JComboBox[3];
      items = new JMenuItem[2];
      controller = null;
      createComponents();
      initializeComponents();
      addComponentsToFrame();
   }

   private void addComponentsToFrame()
   {
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(new CardLayout(0, 0));
      bar.add(menu);
      menu.add(items[0]);
      menu.add(items[1]);
      this.setJMenuBar(bar);
      
      //mainPanel
      mainPanel.setLayout(null);
      labels[0].setFont(new Font("Lucida Grande", Font.PLAIN, 22));
      labels[0].setBounds(517, 19, 174, 27);
      mainPanel.add(labels[0]);
      labels[1].setBounds(56, 67, 61, 16);
      mainPanel.add(labels[1]);
      labels[2].setBounds(599, 96, 61, 16);
      mainPanel.add(labels[2]);
      labels[3].setBounds(825, 96, 77, 16);
      mainPanel.add(labels[3]);
      scrollPanes[0].setBounds(56, 95, 472, 539);
      mainPanel.add(scrollPanes[0]);
      Object rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3", "Row1-Column4"},
            { "Row2-Column1", "Row2-Column2", "Row2-Column3", "Row2-Column4"}};
      Object columnNames[] = { "Origin", "Destination", "Date", "Time"};
      tables[0] = new JTable(rowData, columnNames);
      tables[0].setName("flightTable");
      scrollPanes[0].setViewportView(tables[0]);
      buttons[0].setBackground(Color.WHITE);
      buttons[0].setBounds(331, 637, 117, 29);
      mainPanel.add(buttons[0]);
      comboBoxes[0].setBounds(672, 92, 200, 27);
      comboBoxes[0].setName("Origin");
      mainPanel.add(comboBoxes[0]);
      comboBoxes[1].setBounds(936, 92, 200, 27);
      comboBoxes[1].setName("Destination");
      mainPanel.add(comboBoxes[1]);
      buttons[1].setBounds(744, 131, 117, 29);
      mainPanel.add(buttons[1]);
      buttons[2].setBounds(114, 637, 141, 29);
      mainPanel.add(buttons[2]);
      contentPane.add(mainPanel, "mainPanel"); // name for mainPanel
      //finished mainPanel
      
      //bookPanel
      bookPanel.setLayout(null);
      labels[4].setFont(new Font("Lucida Grande", Font.PLAIN, 22));
      labels[4].setBounds(28, 23, 176, 32);
      bookPanel.add(labels[4]);
      labels[5].setBounds(28, 124, 230, 16);
      labels[5].setName("flightId");
      bookPanel.add(labels[5]);
      labels[6].setBounds(28, 208, 200, 16);
      labels[6].setName("departureDate");
      bookPanel.add(labels[6]);
      labels[7].setBounds(275, 208, 200, 16);
      labels[7].setName("arrivalDate");
      bookPanel.add(labels[7]);
      labels[8].setBounds(28, 251, 200, 16);
      labels[8].setName("departureTime");
      bookPanel.add(labels[8]);
      labels[9].setBounds(275, 251, 200, 16);
      labels[9].setName("arrivalTime");
      bookPanel.add(labels[9]);
      labels[10].setBounds(28, 168, 260, 16);
      labels[10].setName("origin");
      bookPanel.add(labels[10]);
      labels[11].setBounds(275, 168, 260, 16);
      labels[11].setName("destination");
      bookPanel.add(labels[11]);
      labels[12].setBounds(214, 395, 200, 16);
      labels[12].setName("name");
      bookPanel.add(labels[12]);
      labels[13].setBounds(28, 444, 200, 16);
      labels[13].setName("email");
      bookPanel.add(labels[13]);
      labels[14].setBounds(214, 444, 200, 16);
      labels[14].setName("phone");
      bookPanel.add(labels[14]);
      labels[15].setBounds(28, 395, 87, 16);
      labels[15].setName("id");
      bookPanel.add(labels[15]);
      comboBoxes[2].setBounds(690, 108, 108, 27);
      comboBoxes[2].setName("location");
      bookPanel.add(comboBoxes[2]);
      labels[16].setBounds(550, 112, 153, 16);
      labels[16].setName("chooseSeat");
      bookPanel.add(labels[16]);
      scrollPanes[1].setBounds(550, 181, 265, 378);
      bookPanel.add(scrollPanes[1]);
      Object rowData1[][] = {{"Row1-Column1"}};
      Object columnNames1[] = {"Seat no."}; 
      tables[1] = new JTable(rowData1, columnNames1);
      tables[1].setName("seatTable");
      scrollPanes[1].setViewportView(tables[1]);
      labels[17].setBounds(620, 153, 108, 16);
      bookPanel.add(labels[17]);
      buttons[3].setBounds(620, 570, 117, 29);
      bookPanel.add(buttons[3]);
      buttons[4].setBounds(28, 608, 117, 29);
      bookPanel.add(buttons[4]);
      contentPane.add(bookPanel, "bookPanel"); //name for bookPanel
      //finished bookPanel
      
      //viewProfilePanel
      viewProfilePanel.setLayout(null);
      labels[18].setBounds(46, 34, 200, 16);
      labels[18].setName("names");
      viewProfilePanel.add(labels[18]);
      labels[19].setBounds(46, 90, 200, 16);
      labels[19].setName("emails");
      viewProfilePanel.add(labels[19]);
      labels[20].setBounds(46, 134, 211, 16);
      labels[20].setName("phones");
      viewProfilePanel.add(labels[20]);
      labels[21].setBounds(46, 178, 211, 16);
      labels[21].setName("passport");
      viewProfilePanel.add(labels[21]);
      buttons[5].setBounds(40, 610, 117, 29);
      viewProfilePanel.add(buttons[5]);
      scrollPanes[2].setBounds(537, 102, 578, 273);
      viewProfilePanel.add(scrollPanes[2]);
      Object rowData2[][] = {{"Row1-Column1"}, {"Row1-Column2"}, {"Row1-Column3"}, {"Row1-Column4"}, {"Row1-Column5"}, {"Row1-Column6"}};
      Object columnNames2[] = {"TicketID", "Origin", "Destination", "Date", "Time", "Seat"}; 
      tables[2] = new JTable(rowData2, columnNames2);
      tables[2].setName("ticketTable");
      scrollPanes[2].setViewportView(tables[2]);
      labels[22].setBounds(537, 58, 126, 16);
      viewProfilePanel.add(labels[22]);
      contentPane.add(viewProfilePanel, "viewProfilePanel");
      //finished viewProfilePanel
      
      //homePanel
      homePanel.setLayout(null);
      labels[23].setBounds(530, 33, 350, 25);
      labels[23].setFont(new Font("Tahoma", Font.PLAIN, 30));
      homePanel.add(labels[23]);
      labels[24].setBounds(510, 148, 150, 30);
      labels[24].setFont(new Font("Arial", Font.PLAIN, 19));
      homePanel.add(labels[24]);
      labels[25].setBounds(510, 196, 150, 14);
      labels[25].setFont(new Font("Arial", Font.PLAIN, 19));
      homePanel.add(labels[25]);
      fields[0].setBounds(623, 148, 178, 30);
      fields[0].setColumns(10);
      fields[0].setName("username");
      homePanel.add(fields[0]);
      fields[1].setBounds(623, 189, 178, 30);
      fields[1].setColumns(10);
      fields[1].setName("password");
      homePanel.add(fields[1]);
      buttons[6].setBounds(600, 260, 89, 40);
      homePanel.add(buttons[6]);
      buttons[7].setBounds(600, 310, 89, 40);
      homePanel.add(buttons[7]);
      contentPane.add(homePanel, "homePanel");
      //finished homePanel
      
      //signUpPanel
      signUpPanel.setLayout(null);
      labels[26].setFont(new Font("Tahoma", Font.PLAIN, 30));
      labels[26].setBounds(615, 6, 139, 39);
      signUpPanel.add(labels[26]);
      labels[27].setBounds(531, 92, 100, 14);
      labels[27].setFont(new Font("Tahoma", Font.PLAIN, 15));
      signUpPanel.add(labels[27]);
      labels[28].setBounds(531, 124, 100, 14);
      labels[28].setFont(new Font("Tahoma", Font.PLAIN, 15));
      signUpPanel.add(labels[28]);
      labels[29].setBounds(531, 205, 77, 14);
      labels[29].setFont(new Font("Tahoma", Font.PLAIN, 15));
      signUpPanel.add(labels[29]);
      labels[30].setBounds(531, 307, 77, 14);
      labels[30].setFont(new Font("Tahoma", Font.PLAIN, 15));
      signUpPanel.add(labels[30]);
      labels[31].setBounds(531, 337, 89, 14);
      labels[31].setFont(new Font("Tahoma", Font.PLAIN, 15));
      signUpPanel.add(labels[31]);
      labels[32].setBounds(531, 271, 77, 14);
      labels[32].setFont(new Font("Tahoma", Font.PLAIN, 15));
      signUpPanel.add(labels[33]);
      labels[33].setBounds(531, 237, 150, 16);
      labels[33].setFont(new Font("Tahoma", Font.PLAIN, 15));
      signUpPanel.add(labels[32]);
      fields[2].setBounds(629, 89, 180, 20);
      fields[2].setColumns(10);
      fields[2].setName("firstName");
      signUpPanel.add(fields[2]);
      fields[3].setColumns(10);
      fields[3].setBounds(629, 121, 180, 20);
      fields[3].setName("lastName");
      signUpPanel.add(fields[3]);
      fields[4].setColumns(10);
      fields[4].setBounds(629, 202, 180, 20);
      fields[4].setName("email");
      signUpPanel.add(fields[4]);
      fields[5].setColumns(10);
      fields[5].setBounds(629, 268, 180, 20);
      fields[5].setName("phone");
      signUpPanel.add(fields[5]);
      fields[6].setColumns(10);
      fields[6].setBounds(629, 304, 180, 20);
      fields[6].setName("usernameField");
      signUpPanel.add(fields[6]);
      fields[7].setColumns(10);
      fields[7].setBounds(629, 334, 180, 20);
      fields[7].setName("passwordField");
      signUpPanel.add(fields[7]);
      fields[8].setBounds(629, 234, 180, 26);
      fields[8].setColumns(10);
      fields[8].setName("passportNo");
      signUpPanel.add(fields[8]);
      separator.setBounds(529, 159, 292, 12);
      signUpPanel.add(separator);
      buttons[8].setBounds(629, 405, 89, 40);
      signUpPanel.add(buttons[8]);
      contentPane.add(signUpPanel, "signUpPanel");
      //finished signUpPanel
   }

   private void initializeComponents()
   {
      setSize(1280, 720); // set frame size
      setLocationRelativeTo(null); // center of the screen
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   private void createComponents()
   {
      contentPane = new JPanel();
      mainPanel = new JPanel();
      labels[0] = new JLabel("Welcome to ZAir");
      labels[1] = new JLabel("Flights: ");
      labels[2] = new JLabel("Origin:");
      labels[3] = new JLabel("Destination:");
      scrollPanes[0] = new JScrollPane();
      buttons[0] = new JButton("Book");
      comboBoxes[0] = new JComboBox<>();
      comboBoxes[0].setModel(new DefaultComboBoxModel<>(locations));
      comboBoxes[1] = new JComboBox<>();
      comboBoxes[1].setModel(new DefaultComboBoxModel<>(locations));
      buttons[1] = new JButton("Search");
      buttons[2] = new JButton("Cheapest flights");
      bookPanel = new JPanel();
      labels[4] = new JLabel("Booking ticket");
      labels[5] = new JLabel("FlightID:");
      labels[6] = new JLabel("Departure date:");
      labels[7] = new JLabel("Arrival date:");
      labels[8] = new JLabel("Departure time:");
      labels[9] = new JLabel("Arrival time:");
      labels[10] = new JLabel("Origin:");
      labels[11] = new JLabel("Destination:");
      labels[12] = new JLabel("Name:");
      labels[13] = new JLabel("Email:");
      labels[14] = new JLabel("Telephone nr.:");
      labels[15] = new JLabel("CustomerID:");
      comboBoxes[2] = new JComboBox<>();
      labels[16] = new JLabel("Choose seat location:");
      scrollPanes[1] = new JScrollPane();
      labels[17] = new JLabel("Available seats:");
      buttons[3] = new JButton("Confirm");
      buttons[4] = new JButton("Back");
      viewProfilePanel = new JPanel();
      labels[18] = new JLabel("");
      labels[19] = new JLabel("Email:");
      labels[20] = new JLabel("Telephone no.:");
      labels[21] = new JLabel("Passport no.:");
      buttons[5] = new JButton("Back");
      scrollPanes[2] = new JScrollPane();
      labels[22] = new JLabel("My flight history: ");
      bar = new JMenuBar();
      menu = new JMenu("My profile");
      items[0] = new JMenuItem("View profile");
      items[1] = new JMenuItem("Sign out");
      homePanel = new JPanel();
      signUpPanel = new JPanel();
      labels[23] = new JLabel("Welcome to ZAir");
      labels[24] = new JLabel("Username: ");
      labels[25] = new JLabel("Password: ");
      for (int i = 0; i < fields.length; i++)
      {
         fields[i] = new JTextField();
      }
      buttons[6] = new JButton("Log in");
      buttons[7] = new JButton("Sign up");
      labels[26] = new JLabel("Sign up");
      labels[27] = new JLabel("First name: ");
      labels[28] = new JLabel("Last name: ");
      labels[29] = new JLabel("Email: ");
      labels[30] = new JLabel("Username: ");
      labels[31] = new JLabel("Password: ");
      labels[32] = new JLabel("Phone: ");
      labels[33] = new JLabel("Passport no.: ");
      separator = new JSeparator();
      buttons[8] = new JButton("Register");
    }
   
   public void startController(CustomerController controller)
   {
      this.controller = controller;
      handler = new ButtonHandler(this, controller);
      listener = new MenuHandler(this, controller);
      for (int i = 0; i < buttons.length; i++)
      {
         buttons[i].addActionListener(handler);
      }
      for (int i = 0; i < items.length; i++)
      {
         items[i].addActionListener(listener);
      }
      setVisible(true);
   }

   @Override
   public void switchPanelTo(String panel)
   {
      CardLayout layout = (CardLayout) contentPane.getLayout();
      layout.show(contentPane, panel);
   }

   @Override
   public void launchOption(String messageType)
   {
      JOptionPane.showMessageDialog(null, messageType);
   }

   @Override
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
   public int getSelectedIndex(String name)
   {
      int index = 0;
      for (int i = 0; i < tables.length; i++)
      {
         if (tables[i].getName().equals(name))
         {
            index = tables[i].getSelectedRow();
         }
      }
      
      return index;
   }

   @Override
   public void loadFlights(String[] flight)
   {
       String[] col = {"Origin", "Destination", "Date", "Time"};
       DefaultTableModel model = new DefaultTableModel(col, 0);
       for (int i = 0; i < flight.length; i++)
       {
          String[] array = flight[i].split("<");
          model.addRow(array);
       }
       tables[0].setModel(model);
   }
   
   private void loadTickets(String[] tickets)
   {
      String[] col = {"TicketID", "Origin", "Destination", "Date", "Time", "Seat"}; 
      DefaultTableModel model = new DefaultTableModel(col, 0);
      for (int i = 0; i < tickets.length; i++)
      {
         String[] array = tickets[i].split("<");
         model.addRow(array);
      }
      tables[2].setModel(model);
   }

   private void loadSeats(String[] seats)
   {
      String[] col = {"Seatno."};
      DefaultTableModel model = new DefaultTableModel(col, 0);
      for (int i = 0; i < seats.length; i++)
      {
         String[] array = new String[1];
         array[0] = seats[i];
         model.addRow(array);
      }
      tables[1].setModel(model);
   }

   @Override
   public void loadCustomer(String customerDetails, String[] tickets)
   {
      String[] input = customerDetails.split("<");
      labels[12].setText("Name: " + input[0]); //name
      labels[13].setText("Email: " + input[1]); //email
      labels[14].setText("Phone number: " + input[2]); //phone
      labels[18].setText("Name: " + input[0]);
      labels[19].setText("Email: " + input[1]);
      labels[20].setText("Phone number: " + input[2]);
      labels[21].setText("Passport NO: " + input[3]); //passport
      loadTickets(tickets);
   }

   @Override
   public void loadSpecificFlight(String flightDetails, String[] seats)
   {
      String[] input = flightDetails.split("<");
      labels[5].setText("FlightID: " + input[0]); //flightId
      labels[6].setText("Departure date: " + input[1]); //depDate
      labels[7].setText("Arrival date: " + input[2]); //arrDate
      labels[8].setText("Departure time: " + input[3]); //depTime
      labels[9].setText("Arrival time: " + input[4]); //arrTime
      labels[10].setText("Origin: " + input[5]); //origin
      labels[11].setText("Destination: " + input[6]); //destination
      loadSeats(seats);
      
   }

   @Override
   public boolean isRowSelected(String name)
   {
      boolean valid = true;
      for (int i = 0; i < tables.length; i++)
      {
         if (tables[i].getName().equals(name))
         {
            valid = !tables[i].getSelectionModel().isSelectionEmpty();
         }
      }
      
      return valid;
   }

   @Override
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
   
   
  
}
