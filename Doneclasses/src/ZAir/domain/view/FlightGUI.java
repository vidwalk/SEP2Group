package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

public class FlightGui extends JFrame implements FlightView
{
   
   private ButtonHandler handler;
   private JPanel mainPanel; 
   private JPanel loginPanel;
   private JPanel flightPanel;
   private JPanel addFlightPanel;
   private JPasswordField passwordField;
   private JLabel lblWelcomeToZair;
   private JLabel lblLogin;
   private JTextArea txtrInsertHere;
   private JLabel lblPassword;
   private JButton btnLogin;
   private JButton btnSignUp;
   private JList<String> flightList;
   private JButton btnAdd;
   private JButton btnRemove;
   private JLabel lblFlights;
   private JButton btnExit;
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
   private JDateChooser dateChooser;
   private JDateChooser dateChooser_1;
   private JComboBox comboBox_2;
   private JComboBox comboBox_3;
   private JButton btnSave;
   private JButton btnBack;
   
   
   public FlightGui()
   {
      super("ZAir");
      createComponents();
      initializeComponents();
      addComponentsToFrame();
   }
   
   public void start()
   {
      handler = new ButtonHandler(this);
      setVisible(true);
      btnLogin.addActionListener(handler);
      btnAdd.addActionListener(handler);
      btnSave.addActionListener(handler);
   }

   private void createComponents()
   {
      mainPanel = new JPanel(new CardLayout());
      loginPanel = new JPanel(new BorderLayout());
      addFlightPanel = new JPanel();
      lblWelcomeToZair = new JLabel("Welcome to ZAir");
      lblWelcomeToZair.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
      lblLogin = new JLabel("login");
      lblLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
      txtrInsertHere = new JTextArea();
      txtrInsertHere.setBorder(new LineBorder(Color.LIGHT_GRAY));
      lblPassword = new JLabel("password");
      lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
      passwordField = new JPasswordField();
      btnLogin = new JButton("log-in");
      btnSignUp = new JButton("sign up");
      flightList = new JList<>();
      
      // just for design
      flightList.setModel(new AbstractListModel() {
         String[] values = new String[] {"lol", "lol2"};
         public int getSize() {
            return values.length;
         }
         public Object getElementAt(int index) {
            return values[index];
         }
      });
      flightList.setFont(new Font("Arial", Font.BOLD,16));
      flightList.setFixedCellHeight(40);
      // to delete later
      
      flightPanel = new JPanel();
      btnAdd = new JButton("Add");
      btnRemove = new JButton("Remove");
      lblFlights = new JLabel("Flights: ");
      lblFlights.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
      btnExit = new JButton("Sign out");
      searchTextField = new JTextField();
      searchTextField.setColumns(10);
      lblSearch = new JLabel("Search:");
      btnOk = new JButton("OK");
      lblAddFlight = new JLabel("Add flight:");
      lblAddFlight.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
      lblOrigin = new JLabel("Origin:");
      comboBox = new JComboBox();
      lblDestination = new JLabel("Destination:");
      comboBox_1 = new JComboBox();
      lblDeparturedDate = new JLabel("Departured Date: ");
      lblArrivalDate = new JLabel("Arrival Date:");
      lblDepartureTime = new JLabel("Departure Time:");
      lblArrivalTime = new JLabel("Arrival Time:");
      lblPrice = new JLabel("Price:");
      textField_2 = new JTextField();
      textField_2.setColumns(10);
      dateChooser = new JDateChooser();
      dateChooser_1 = new JDateChooser();
      comboBox_2 = new JComboBox();
      comboBox_3 = new JComboBox();
      btnSave = new JButton("Save");
      btnBack = new JButton("Back");
   }

   private void initializeComponents()
   {
      setSize(1280, 720); // set frame size
      setLocationRelativeTo(null); // center of the screen
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   private void addComponentsToFrame()
   {
      // login panel
      loginPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
      loginPanel.setBounds(100, 100, 450, 300);
      lblWelcomeToZair.setHorizontalAlignment(SwingConstants.CENTER);
      lblWelcomeToZair.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
      loginPanel.add(lblWelcomeToZair, BorderLayout.NORTH);
      JPanel panel_1 = new JPanel();
      loginPanel.add(panel_1, BorderLayout.CENTER);
      panel_1.setLayout(null);
      lblLogin.setBounds(547, 108, 54, 29);
      panel_1.add(lblLogin);
      txtrInsertHere.setBounds(613, 116, 118, 20);
      panel_1.add(txtrInsertHere);
      lblPassword.setBounds(503, 136, 98, 29);
      panel_1.add(lblPassword);
      passwordField.setBounds(610, 143, 124, 20);
      panel_1.add(passwordField);
      btnLogin.setBounds(577, 192, 117, 29);
      panel_1.add(btnLogin);
      btnSignUp.setBounds(577, 224, 117, 29);
      panel_1.add(btnSignUp);
      mainPanel.add(loginPanel, "login-panel"); //name for loginPanel for CardLayout
     // finished login panel
      
      // flight panel
      flightPanel.setBounds(100, 100, 450, 300);
      flightPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
      flightPanel.setLayout(new BorderLayout(0, 0));
      JPanel panel_2 = new JPanel();
      flightPanel.add(panel_2, BorderLayout.CENTER);
      panel_2.setLayout(null);
      flightList.setBounds(51, 60, 504, 566);
      panel_2.add(flightList);
      btnAdd.setBounds(46, 638, 117, 29);
      panel_2.add(btnAdd);
      btnRemove.setBounds(175, 638, 117, 29);
      panel_2.add(btnRemove);
      lblFlights.setBounds(51, 10, 260, 38);
      panel_2.add(lblFlights);
      btnExit.setBounds(304, 638, 117, 29);
      panel_2.add(btnExit);
      searchTextField.setBounds(370, 27, 130, 18);
      panel_2.add(searchTextField);
      lblSearch.setBounds(304, 28, 61, 16);
      panel_2.add(lblSearch);
      btnOk.setBounds(512, 23, 43, 25);
      panel_2.add(btnOk);
      mainPanel.add(flightPanel, "flight-panel");  //name for flightPanel for CardLayout
      //finished flight panel
      
      // add flight panel
      addFlightPanel.setBounds(100, 100, 450, 300);
      addFlightPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
      addFlightPanel.setLayout(null);
      lblAddFlight.setBounds(27, 6, 139, 24);
      addFlightPanel.add(lblAddFlight);
      lblOrigin.setBounds(73, 79, 43, 16);
      addFlightPanel.add(lblOrigin);
      comboBox.setBounds(128, 75, 52, 27);
      addFlightPanel.add(comboBox);
      lblDestination.setBounds(39, 121, 77, 16);
      addFlightPanel.add(lblDestination);
      comboBox_1.setBounds(128, 114, 52, 27);
      addFlightPanel.add(comboBox_1);
      lblDeparturedDate.setBounds(39, 183, 111, 16);
      addFlightPanel.add(lblDeparturedDate);
      lblArrivalDate.setBounds(73, 221, 78, 16);
      addFlightPanel.add(lblArrivalDate);
      lblDepartureTime.setBounds(49, 284, 101, 16);
      addFlightPanel.add(lblDepartureTime);
      lblArrivalTime.setBounds(73, 317, 80, 16);
      addFlightPanel.add(lblArrivalTime);
      lblPrice.setBounds(363, 79, 34, 16);
      addFlightPanel.add(lblPrice);
      textField_2.setBounds(408, 74, 130, 26);
      addFlightPanel.add(textField_2);
      dateChooser.setBounds(162, 178, 131, 26);
      addFlightPanel.add(dateChooser);
      dateChooser_1.setBounds(162, 211, 131, 26);
      addFlightPanel.add(dateChooser_1);
      comboBox_2.setBounds(162, 280, 52, 27);
      addFlightPanel.add(comboBox_2);
      comboBox_3.setBounds(165, 313, 52, 27);
      addFlightPanel.add(comboBox_3);
      btnSave.setBounds(382, 326, 75, 29);
      addFlightPanel.add(btnSave);
      btnBack.setBounds(469, 326, 75, 29);
      addFlightPanel.add(btnBack);
      mainPanel.add(addFlightPanel, "add-flight");  //name for addFlightPanel for CardLayout
      //finished add flight panel
      
      
      // sets contentPane
      setContentPane(mainPanel);
      //sets ContentPane
   }

   public void switchPanelTo(String panel)
   {
      CardLayout layout = (CardLayout) mainPanel.getLayout();
      layout.show(mainPanel, panel);
   }
   
   @Override
   public void show(String value)
   {
      // later be replaced by Observer Pattern
   }

   @Override
   public String get(String what)
   {
      String output = null;
      switch (what)
      {
         case "search": output = textField_2.getText(); break;
      }
      return output;
      // gets input from textfields using a String token
   }
   
   public static void main(String[] args)
   {
      FlightGui gui = new FlightGui();
      gui.start();
   }
}
