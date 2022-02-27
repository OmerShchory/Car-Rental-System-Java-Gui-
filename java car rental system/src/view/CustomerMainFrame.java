/**
 * Class represents the main frame of the customer
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
public class CustomerMainFrame extends JFrame {
	private static final long serialVersionUID = 12423431L;
	/**
	 * header, type JLabel is the header of the frame
	 */
	private JLabel header;
	/**
	 * branches, type JButton is the show branches button
	 */
	private JButton branches;
	/**
	 * rent, type JButton is the rent a car button
	 */
	private JButton rent;

	/**
	 * Constructor
	 */
	public CustomerMainFrame() {
		super("Customer Frame");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CustomerMainFrame.class.getResource("/IMAGES/car ICON.png")));
		getContentPane().setBackground(new Color(25, 25, 112));
		setResizable(false);
		setTitle("Customer");
		header = new JLabel("Hello Dear Customer! Please choose an option: ");
		header.setForeground(new Color(255, 255, 255));
		header.setFont(new Font("Open Sans", Font.BOLD, 15));
		header.setBounds(68, 26, 397, 23);
		branches = new JButton("Show branches Details:");
		branches.setBackground(new Color(0, 139, 139));
		branches.setForeground(new Color(255, 255, 255));
		branches.setFont(new Font("Articulate Extrabold", Font.BOLD, 12));
		branches.setBounds(50, 146, 194, 41);
		//what happens when branches button is pressed
		branches.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				CustomerBranches f = new CustomerBranches();
					f.setVisible(true);
			}
			}
		);
		rent = new JButton("Rent a Car");
		rent.setBackground(new Color(0, 139, 139));
		rent.setForeground(new Color(255, 255, 255));
		rent.setFont(new Font("Articulate Extrabold", Font.BOLD, 12));
		rent.setBounds(304, 146, 136, 41);
		rent.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				CustomerRent f = new CustomerRent();
					f.setVisible(true);
			}
			
			}
		);
		initialize();
	}
	
	/**
	 * function initialize the frame components and adds them to the frame
	 */
	public void initialize() {
		getContentPane().setLayout(null);
		getContentPane().add(header);
		getContentPane().add(branches);
        getContentPane().add(rent);
        
        JLabel branchTimeImg = new JLabel("");
        branchTimeImg.setIcon(new ImageIcon(CustomerMainFrame.class.getResource("/IMAGES/branchTime.png")));
        branchTimeImg.setBounds(112, 60, 87, 86);
        getContentPane().add(branchTimeImg);
        
        JLabel rentCarImg = new JLabel("");
        rentCarImg.setIcon(new ImageIcon(CustomerMainFrame.class.getResource("/IMAGES/rentCar.png")));
        rentCarImg.setBounds(343, 70, 97, 76);
        getContentPane().add(rentCarImg);
		setSize(506,252);

	}
	
}
