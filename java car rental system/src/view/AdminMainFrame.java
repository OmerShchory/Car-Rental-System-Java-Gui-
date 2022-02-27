/**
 * Class represents the admin main frame 
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
public class AdminMainFrame extends JFrame {
	private static final long serialVersionUID = 12234231L;
	/**
	 * header, type JLabel is the header of the frame
	 */
	private JLabel header;
	/**
	 * add_branch, type JButton is the add branch button
	 */
	private JButton add_branch;
	/**
	 * add_car, type JButton is the add car button
	 */
	private JButton add_Car;
	/**
	 * addBranchImg, type JLabel is a label for the add branch image
	 */
	private JLabel addBranchImg;
	/**
	 * addcarImg, type JLabel is a label for the add car image
	 */
	private JLabel addCarImg; 

	/**
	 * Constructor
	 */
	public AdminMainFrame() {
		super("Admin Frame");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminMainFrame.class.getResource("/IMAGES/car ICON.png")));
		setResizable(false);
		setTitle("Admin");
		getContentPane().setBackground(new Color(0, 51, 102));
		addCarImg = new JLabel("New label");
	    addBranchImg = new JLabel("");
		header = new JLabel("Hello Dear Admin! Please choose an option: ");
		header.setForeground(Color.WHITE);
		header.setFont(new Font("Open Sans Extrabold", Font.BOLD, 14));
		header.setBounds(48, 25, 369, 23);
		add_branch = new JButton("Add a new branch");
		add_branch.setBackground(new Color(0, 100, 0));
		add_branch.setForeground(Color.WHITE);
		add_branch.setFont(new Font("Articulate Extrabold", Font.BOLD, 13));
		add_branch.setBounds(21, 150, 176, 36);
		
		//what happens when add branch button is pressed
		add_branch.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				AdminAddBranch f = new AdminAddBranch();
					f.setVisible(true);
			}
			
		} );
		add_Car = new JButton("Add a new car");
		add_Car.setBackground(new Color(0, 100, 0));
		add_Car.setForeground(Color.WHITE);
		add_Car.setFont(new Font("Articulate Extrabold", Font.BOLD, 13));
		add_Car.setBounds(249, 150, 168, 36);
		
		//what happens when add car button is pressed
		add_Car.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				AdminAddCar f = new AdminAddCar();
					f.setVisible(true);
			}
			
			}

		);
		initialize();
	}	
	/**
	 * function initialize choice of hours
	 */
	public void initialize() {
	     getContentPane().setLayout(null);
	     getContentPane().add(header);
	     getContentPane().add(add_branch);
	     getContentPane().add(add_Car);
	     addCarImg.setIcon(new ImageIcon(AdminMainFrame.class.getResource("/IMAGES/addcaricon.png")));
	     addCarImg.setBounds(294, 59, 82, 86);
	     getContentPane().add(addCarImg);
	     addBranchImg.setIcon(new ImageIcon(AdminMainFrame.class.getResource("/IMAGES/addbranchicon__.png")));
	     addBranchImg.setBounds(70, 58, 82, 81);
	     getContentPane().add(addBranchImg);
        setSize(443, 262);
	}
	
}
