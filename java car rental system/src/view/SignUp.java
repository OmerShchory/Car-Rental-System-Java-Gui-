/**
 * Class represents frame of sign up form
 */
package view;
import model.*;
import controller.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.regex.*;
import com.toedter.calendar.JDateChooser;    
import java.util.Date;  

/**
 * 
 * @author david and omer
 *
 */
public class SignUp extends JFrame { /**
	 * 
	 */
	private static final long serialVersionUID = 13123L;
	/**
	 * F_name, type JLabel is first name label
	 */
	private JLabel F_name;
	/**
	 * F_name_input, type JTextField is the First name text input
	 */
	private JTextField F_name_input;
	/**
	 * L_name, type JLabel is last name label
	 */
	private JLabel L_name;
	/**
	 * L_name_input, type JTextField the last name text input
	 */
	private JTextField L_name_input;
	/**
	 * ID, type JLabel is the id label
	 */
	private JLabel ID;
	/**
	 * ID_input, type JTextField is the id text input
	 */
	private JTextField ID_input;
	/**
	 * Email, type JLabel is the Email label
	 */
	private JLabel Email;
	/**
	 * Email_input, type is the email text input
	 */
	private JTextField Email_input;
	/**
	 * date_birth, type JLabel is the date of birth label
	 */
	private JLabel date_birth;
	/**
	 * year_license, type JLabel year of license label
	 */
	private JLabel year_license;
	/**
	 * password_one, type JLabel is password one label
	 */
	private JLabel password_one;
	/**
	 * password_one_input, type JPasswordField is password one input
	 */
	private JPasswordField password_one_input;
	/**
	 * password_two, type JLabel is the password two label
	 */
	private JLabel password_two;
	/**
	 * password_two_input, type JPasswordField is the password two input
	 */
	private JPasswordField password_two_input;
	/**
	 * submit, type JButton is the submit button
	 */
	private JButton submit;
	/**
	 * header, type JLabel is the header label
	 */
	private JLabel header;
	/**
	 * signupIMG, type JLabel is the sign up image label
	 */
	private JLabel signupIMG;
	/**
	 * dateChooser, type JDateChooser is the date chooser
	 */
	private JDateChooser dateChooser;
	/**
	 * yearChooser, type Choice is the year chooser
	 */
	private Choice yearChooser;
	
	/**
	 * Constructor
	 */
	public SignUp() 
	{
		super("Sign Up frame");
		setResizable(false);
		getContentPane().setBackground(new Color(0, 128, 128));
		setIconImage(Toolkit.getDefaultToolkit().getImage(SignUp.class.getResource("/IMAGES/car ICON.png")));
		setTitle("Sign Up");
		F_name = new JLabel("First-Name: ");
	    dateChooser = new JDateChooser();
	    // restrict birth date from be in the future
	    LocalDate localDate = LocalDate.now();
	    Date now = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	    dateChooser.setMaxSelectableDate(now);
	    yearChooser = new Choice();
		F_name.setFont(new Font("Open Sans", Font.BOLD, 13));
		F_name.setBounds(63, 60, 102, 14);
		F_name_input = new JTextField(10);
		F_name_input.setFont(new Font("Open Sans", Font.PLAIN, 13));
		F_name_input.setBounds(165, 57, 124, 20);
		L_name = new JLabel("Last-Name: ");
		L_name.setFont(new Font("Open Sans", Font.BOLD, 13));
		L_name.setBounds(63, 102, 86, 14);
		L_name_input = new JTextField(10);
		L_name_input.setFont(new Font("Open Sans", Font.PLAIN, 13));
		L_name_input.setBounds(164, 99, 125, 20);
		ID = new JLabel("ID: ");
		ID.setFont(new Font("Open Sans", Font.BOLD, 13));
		ID.setBounds(339, 60, 27, 14);
		ID_input = new JTextField(10);
		ID_input.setFont(new Font("Open Sans", Font.PLAIN, 13));
		ID_input.setBounds(402, 57, 163, 20);
		Email = new JLabel("Email Address: ");
		Email.setFont(new Font("Open Sans", Font.BOLD, 13));
		Email.setBounds(299, 99, 102, 14);
		Email_input = new JTextField(10);
		Email_input.setFont(new Font("Open Sans", Font.PLAIN, 13));
		Email_input.setBounds(402, 96, 163, 20);
		date_birth = new JLabel("Birth-Date : ");
		date_birth.setFont(new Font("Open Sans", Font.BOLD, 13));
		date_birth.setBounds(63, 142, 86, 14);	
		year_license = new JLabel("Driving license year: ");
		year_license.setFont(new Font("Open Sans", Font.BOLD, 13));
		year_license.setBounds(10, 167, 141, 35);
		password_one = new JLabel("Password: ");
		password_one.setFont(new Font("Open Sans", Font.BOLD, 13));
		password_one.setBounds(80, 216, 76, 14);
		password_one_input = new JPasswordField(10);
		password_one_input.setFont(new Font("Open Sans", Font.PLAIN, 13));
		password_one_input.setBounds(165, 213, 124, 20);
		password_two = new JLabel("Password validation: ");
		password_two.setFont(new Font("Open Sans", Font.BOLD, 13));
		password_two.setBounds(299, 216, 141, 14);
		password_two_input = new JPasswordField(10);
		password_two_input.setFont(new Font("Open Sans", Font.PLAIN, 13));
		password_two_input.setBounds(441, 213, 124, 20);
		header = new JLabel("Please enter your details in order to sign up:");
		header.setForeground(new Color(233, 150, 122));
		header.setFont(new Font("Open Sans", Font.BOLD, 22));
		header.setBounds(38, 11, 501, 35);
		submit = new JButton("Submit");
		submit.setForeground(new Color(255, 255, 255));
		submit.setBackground(new Color(0, 0, 139));
		submit.setFont(new Font("Articulate Extrabold", Font.BOLD, 13));
		submit.setBounds(243, 287, 113, 46);
		//what happens when submit is pressed
		submit.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
			
				
				///validation for missing data//
				if(F_name_input.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "First Name field is empty", "Message Frame", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(L_name_input.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Last Name field is empty", "Message Frame", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(ID_input.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "ID field is empty", "Message Frame", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(Email_input.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Email field is empty", "Message Frame", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(dateChooser.getDate()== null) {
					JOptionPane.showMessageDialog(null, "You have to choose a birth date", "Message Frame", JOptionPane.ERROR_MESSAGE);
					return;
				}

				if(password_one_input.getPassword().length == 0) {
					JOptionPane.showMessageDialog(null, "Password field is empty", "Message Frame", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(password_two_input.getPassword().length == 0) {
					JOptionPane.showMessageDialog(null, "Password validation field is empty", "Message Frame", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				//Data Validation//
				//checking First name contains only alphabet letters
				if(!Pattern.matches("[a-zA-Z]+", F_name_input.getText())) {
					JOptionPane.showMessageDialog(null, "Invalid First name", "Message Frame", JOptionPane.ERROR_MESSAGE);
					return;
				}
				//checking Last name contains only alphabet letters
				if(!Pattern.matches("[a-zA-Z]+", L_name_input.getText())) {
					JOptionPane.showMessageDialog(null, "Invalid Last name", "Message Frame", JOptionPane.ERROR_MESSAGE);
					return;
				}
				//checking Id contains only numbers
				if((!ID_input.getText().matches("[0-9]+")) ||ID_input.getText().length() < 6 ) {
				JOptionPane.showMessageDialog(null, "Invalid ID, ID can contain only numbers, and more then 6 digits", "Message Frame", JOptionPane.ERROR_MESSAGE);
				return;
				}
				//check if password one is equal to password two				
				if(!Arrays.equals(password_one_input.getPassword(),password_two_input.getPassword())) { 
					JOptionPane.showMessageDialog(null, "Passwords are not matching", "Message Frame", JOptionPane.ERROR_MESSAGE); 
					return;
				}
				
				//check if the email is valid
		        String regex = "^(.+)@(.+)$";  
		        Pattern pattern = Pattern.compile(regex);  
	            Matcher matcher = pattern.matcher(Email_input.getText());  
				if(!matcher.matches()) {
					JOptionPane.showMessageDialog(null, "Email address is not valid", "Message Frame", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				//check if email is not taken
				for (Person element : MainClass.customer_Manager.getCustomers()) 
				{
				   if(Email_input.getText().equals(element.getEmail()) )
				   {
					   JOptionPane.showMessageDialog(null, "Email address is already taken", "Message Frame", JOptionPane.ERROR_MESSAGE);
					   return;
				   }
				}
				
				//convert date form date chooser
				  Date date = new Date();  
				  date = dateChooser.getDate();
				  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
				  String strDate= formatter.format(date);
				
				//after all the checks - if everything is valid, we can create new customer 
				Customer Cust = new Customer(Email_input.getText(), String.valueOf(password_one_input.getPassword()), F_name_input.getText(), 
						L_name_input.getText(), ID_input.getText(),strDate, String.valueOf(yearChooser.getSelectedItem()));
				
				//add new customer to customer Manager
				MainClass.customer_Manager.addCustomer(Cust);
				
				//writing the MainClass.customer_Manager after the add of a new customer "customer_Manager.txt"
				//Saving of object in a file
				/**
				 * Try to Save the customer object in a file, catch exceptions if occur;
				 */
				  try{    
		
					//Saving of object in a file
					  FileOutputStream file=new FileOutputStream("customer_Manager.txt");    
					  ObjectOutputStream out=new ObjectOutputStream(file);    
					  out.writeObject(MainClass.customer_Manager);    
					  //closing the stream    
					  out.close();    
					  System.out.println("Object has been serialized");
					  
					  JOptionPane.showMessageDialog(null, "Customer was added successfully to the system", "Message Frame", JOptionPane.PLAIN_MESSAGE);
					  setVisible(false); //you can't see me!
					  dispose(); //Destroy the JFrame object

					  }
				  catch(IOException ex)
				  {ex.printStackTrace();}
				
			}
			}
		);
		initializeyear();
		initialize();
	}
	/**
	 * function initialize choice of year
	 */
	public void initializeyear() {
		LocalDate localDate = LocalDate.now();
		for(int i=localDate.getYear();i>=1920;i--) { //range of years in the system for 10 years
			yearChooser.add(String.valueOf(i));

		}
	}
	
	/**
	 * function initialize the frame components and adds them to the frame
	 */
	private void initialize() {
		getContentPane().setLayout(null);
		getContentPane().add(F_name);
		getContentPane().add(F_name_input);
		getContentPane().add(L_name);
		getContentPane().add(L_name_input);
		getContentPane().add(ID);
		getContentPane().add(ID_input);
		getContentPane().add(Email);
		getContentPane().add(Email_input);
		getContentPane().add(date_birth);
		getContentPane().add(year_license);
		getContentPane().add(password_one);
		getContentPane().add(password_one_input);
		getContentPane().add(password_two);
		getContentPane().add(password_two_input);
		getContentPane().add(submit);
		getContentPane().add(header);
		signupIMG = new JLabel("");
		signupIMG.setIcon(new ImageIcon(SignUp.class.getResource("/IMAGES/sign-up_SMAL.png")));
		signupIMG.setBounds(50, 248, 183, 144);
		getContentPane().add(signupIMG);
		dateChooser.setBounds(163, 140, 141, 19);
		getContentPane().add(dateChooser);
		yearChooser.setBounds(165, 177, 102, 20);
		getContentPane().add(yearChooser);
		setSize(593,442);
	}
	
}