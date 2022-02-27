/**
 * Class represents the admin frame of add a new branch to the system
 */
package view;
import model.*;
import controller.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * 
 * @author david and omer
 *
 */
public class SignIn extends JFrame {

	private static final long serialVersionUID = 1231L;
	/**
	 * header, type JLabel is the header of the frame
	 */
	private JLabel header;
	/**
	 * Email, type JLabel is the Email label
	 */
	private JLabel Email;
	/**
	 * Email_input, type JTextField is Email input of the user text input
	 */
	private JTextField Email_input;
	/**
	 * Password, type JLabel is the Password label
	 */
	private JLabel Password;
	/**
	 * password_input, type JTextField is password input of the user text input
	 */
	private JPasswordField password_input;
	/**
	 * log_in, type JButton is the log in button
	 */
	private JButton log_in;
	
	/**
	 * Constructor
	 */
	public SignIn() {
		super("Sign In frame");
		setResizable(false);
		getContentPane().setBackground(new Color(0, 128, 128));
		setTitle("Sign In");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SignIn.class.getResource("/IMAGES/car ICON.png")));
		header = new JLabel("Please write your email address and password to log in the system: ");
		header.setForeground(new Color(233, 150, 122));
		header.setFont(new Font("Open Sans", Font.BOLD, 15));
		header.setBounds(26, 22, 532, 23);
		Email = new JLabel("Email: ");
		Email.setFont(new Font("Open Sans", Font.BOLD, 13));
		Email.setBounds(37, 68, 74, 14);
		Email_input = new JTextField(20);
		Email_input.setFont(new Font("Open Sans", Font.BOLD, 11));
		Email_input.setBounds(86, 66, 166, 20);
		Password = new JLabel("Password: ");
		Password.setFont(new Font("Open Sans", Font.BOLD, 13));
		Password.setBounds(275, 68, 86, 14);
		password_input = new JPasswordField(20);
		password_input.setFont(new Font("Open Sans", Font.BOLD, 11));
		password_input.setBounds(358, 65, 166, 20);
		initialize();
	}
	
	/**
	 * function initialize choice of hours
	 */
	private void initialize() {
        log_in = new JButton("Log In");
        log_in.setForeground(new Color(255, 255, 255));
        log_in.setBackground(new Color(25, 25, 112));
        log_in.setFont(new Font("Articulate Extrabold", Font.BOLD, 13));
        log_in.setBounds(237, 135, 98, 48);
        //what happens if log in is pressed
        log_in.addActionListener(new ActionListener()
        {
        	@Override
        	public void actionPerformed(ActionEvent e) 
        	{
        		//check if email is empty
        		if(Email_input.getText().isEmpty())
        		{
        			JOptionPane.showMessageDialog(null, "Email field is empty", "Message Frame", JOptionPane.ERROR_MESSAGE);
        			return;
        		}
        		//check if password is empty
        		if(password_input.getPassword().length == 0) {
        			JOptionPane.showMessageDialog(null, "Password field is empty", "Message Frame", JOptionPane.ERROR_MESSAGE);
        			return;
        		}
        		
        		boolean is_found = false ;
        		//check if email and password are in the system
        		for (Person element : MainClass.customer_Manager.getCustomers()) 
        		{
        		  
        		   if(Email_input.getText().equals(element.getEmail()) && Arrays.equals(password_input.getPassword(),element.getPassword().toCharArray()))
        		   {
        			   is_found = true;
        			   //if the email is admin email
        			   if(Email_input.getText().equals(MainClass.adminEmail))
        			   {
        				   AdminMainFrame f = new AdminMainFrame();
        				   //hide and close the signIn form
        					  setVisible(false); //you can't see me!
        					  dispose(); //Destroy the JFrame object
        					f.setVisible(true);
        			   }
        			   else
        			   {
        				   CustomerMainFrame f = new CustomerMainFrame();
        					  setVisible(false); //you can't see me!
        					  dispose(); //Destroy the JFrame object
        					f.setVisible(true);
        				   
        			   }
        		   }
        		}
        		
        		if(!is_found)
        		{
        			JOptionPane.showMessageDialog(null, "Email or password was not found in the system", "Message Frame", JOptionPane.ERROR_MESSAGE); 
        			return;
        		}
        	}
        }
        );
        getContentPane().setLayout(null);
        getContentPane().add(Email);
        getContentPane().add(Email_input);
        getContentPane().add(Password);
        getContentPane().add(password_input);
        getContentPane().add(header);
        getContentPane().add(log_in);
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(SignIn.class.getResource("/IMAGES/loginIMG.png")));
        lblNewLabel.setBounds(100, 108, 110, 100);
        getContentPane().add(lblNewLabel);
		setSize(574,258);
	}
	
}
