/**
 * Class represents opening frame of the system
 */
package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author david and omer
 *
 */
public class Opening_Frame extends JFrame{

	private static final long serialVersionUID = 188707070L;
	/**
	 * open_text, type JLabel is the open text label of the frame
	 */
	private JLabel open_text;
	/**
	 * btn_signUp, type JButton is the sign up button
	 */
	private JButton btn_signUp;
	/**
	 * btn_signIn, type JButton is the sign in button
	 */
	private JButton btn_signIn;
	/**
	 * label, type JLabel is the back image label
	 */
	private JLabel label;

	/**
	 * Constructor
	 */
	public Opening_Frame() {
		super("Welcome frame");
		setTitle("Rupin Rent");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Opening_Frame.class.getResource("/IMAGES/car ICON.png")));
		getContentPane().setBackground(new Color(0, 102, 153));
		label = new JLabel(new ImageIcon("/IMAGES/MAINFRAME BACK.jpg"));
		label.setBounds(7, 7, 0, 0);
		getContentPane().add(label);
		initialize();
	}
	
	/**
	 * function initialize the frame components and adds them to the frame
	 */
	private void initialize() {
		open_text = new JLabel("Welcome to 'Ruppin-Rent' system! ");
		open_text.setBounds(82, 143, 481, 32);
		open_text.setFont(new Font("Articulate Extrabold", Font.BOLD, 23));
		open_text.setForeground(new Color(255, 69, 0));
		btn_signUp = new JButton("Sign Up");
		btn_signUp.setBackground(new Color(0, 128, 128));
		btn_signUp.setForeground(new Color(255, 255, 255));
		btn_signUp.setFont(new Font("Articulate Extrabold", Font.BOLD, 13));
		btn_signUp.setBounds(179, 205, 121, 45);
		//what happens when sign up button is pressed
		btn_signUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SignUp f = new SignUp();
				f.setVisible(true);
				}
			}
		);
		JLabel backImage = new JLabel("");
		backImage.setBounds(0, -26, 721, 330);
		backImage.setIcon(new ImageIcon(Opening_Frame.class.getResource("/IMAGES/SMAL MAIN BACK.jpg")));
		getContentPane().setLayout(null);
		getContentPane().add(open_text);
		getContentPane().add(btn_signUp);
		getContentPane().add(label);
		btn_signIn = new JButton("Sign In");
		btn_signIn.setFont(new Font("Articulate Extrabold", Font.BOLD, 13));
		btn_signIn.setForeground(new Color(255, 255, 255));
		btn_signIn.setBackground(new Color(102, 205, 170));
		btn_signIn.setBounds(343, 205, 121, 45);
		//what happens when sign in button is pressed
		btn_signIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				//this.setVisible(false);
				SignIn f_ = new SignIn();
				f_.setVisible(true);
				}
			}
		);
		getContentPane().add(btn_signIn);
		getContentPane().add(backImage);
		setSize(637,316);	
		}
}
