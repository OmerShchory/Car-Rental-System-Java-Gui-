/**
 * Class represents the customer frame for showing all of the branches details
 */
package view;
import model.*;
import controller.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * 
 * @author david and omer
 *
 */
public class CustomerBranches extends JFrame{
	private static final long serialVersionUID = 12223341L;
	/**
	 * header, type JLabel is the header of the frame
	 */
	private JLabel header;
	/**
	 * branchesList, type JList is the list of branches
	 */
	private JList <String> branchesList;
	/**
	 * openingHours, type JLabel is the opening hours label 
	 */
	private JLabel openingHours;
	/**
	 * location, type JLabel is the location label
	 */
	private JLabel location;
	/**
	 * branchNum, type JLabel is the branch number label
	 */
	private JLabel branchNum;
	/**
	 * openingHours_display, type JLabel is the opening hours label of the chosen branch
	 */
	private JLabel openingHours_display;
	/**
	 * location_display, type JLabel is the location label of the chosen branch
	 */
	private JLabel location_display;
	/**
	 * branchNum_display, type JLabel is the branch number label of the chosen branch
	 */
	private JLabel branchNum_display;
	/**
	 * show, type JLabel is the show button after choosing a branch
	 */
	private JButton show;
	/**
	 * branches_header, type JButton is branches header label
	 */
	private JLabel branches_header;
	/**
	 * barnchesModel, type DefaultListModel<String> is the list of branches to add to the Jlist
	 */
	private DefaultListModel<String> barnchesModel;
	
	/**
	 * Constructor
	 */
	public CustomerBranches() 
	{
		super("CustomerBranches");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CustomerBranches.class.getResource("/IMAGES/car ICON.png")));
		setTitle("Branches Details:");
		setResizable(false);
		getContentPane().setBackground(new Color(32, 178, 170));
		header = new JLabel("Please select the number of branch from the list:");
		header.setForeground(new Color(238, 232, 170));
		header.setFont(new Font("Open Sans", Font.BOLD, 14));
		header.setBounds(71, 11, 372, 47);
		barnchesModel = new DefaultListModel<>();
		initializeList();
		branches_header = new JLabel("Branches' Numbers");
		branches_header.setFont(new Font("Open Sans", Font.BOLD, 13));
		branches_header.setBounds(341, 69, 179, 25);
		branchesList  = new JList <String>(barnchesModel);
		branchesList.setDragEnabled(true);
		branchesList.setForeground(new Color(240, 128, 128));
		branchesList.setBackground(new Color(0, 128, 128));
		branchesList.setFont(new Font("Open Sans", Font.BOLD, 13));
		branchesList.setBounds(329, 93, 158, 233);
		openingHours_display = new JLabel("");
		openingHours_display.setForeground(new Color(220, 20, 60));
		openingHours_display.setFont(new Font("Open Sans", Font.BOLD, 13));
		openingHours_display.setBounds(166, 173, 104, 30);
		openingHours = new JLabel("Opening Hours: ");
		openingHours.setFont(new Font("Open Sans", Font.BOLD, 13));
		openingHours.setBounds(47, 169, 109, 34);
		location_display = new JLabel("");
		location_display.setForeground(new Color(220, 20, 60));
		location_display.setFont(new Font("Open Sans", Font.BOLD, 13));
		location_display.setBounds(166, 126, 104, 32);
		location = new JLabel("Location: ");
		location.setFont(new Font("Open Sans", Font.BOLD, 13));
		location.setBounds(47, 126, 103, 32);
		branchNum_display = new JLabel("");
		branchNum_display.setForeground(new Color(220, 20, 60));
		branchNum_display.setFont(new Font("Open Sans", Font.BOLD, 13));
		branchNum_display.setBounds(179, 80, 93, 25);
		show = new JButton ("Show Branch Details");
		show.setForeground(new Color(255, 255, 255));
		show.setBackground(new Color(0, 0, 139));
		show.setFont(new Font("Articulate Extrabold", Font.BOLD, 13));
		show.setBounds(59, 269, 191, 57);
		// what happens after choosing the show button
		show.addActionListener(new ActionListener() {  
             public void actionPerformed(ActionEvent e)        
             {   
            	 // if no branch was chosen
                if(branchesList.getSelectedIndex() != -1){  
                	for(Branch b :MainClass.branches_manager.getBranches())
                	{
                		if(b.getNum_of_branch() == branchesList.getSelectedValue() )
                		{
                			//showing branch details in the labels
                			branchNum_display.setText(b.getNum_of_branch());
                			openingHours_display.setText(b.getOpening_hours());
                			location_display.setText(b.getLocation());
                			return;
                		}
                	}
                }  
                 
             }  
          });   
		branchNum = new JLabel("Branch Number: ");
		branchNum.setFont(new Font("Open Sans", Font.BOLD, 13));
		branchNum.setBounds(47, 80, 122, 25);
		initialize();
	}
	
	/**
	 * function initialize the frame components and adds them to the frame
	 */
	public void initialize() {
		getContentPane().setLayout(null);
		getContentPane().add(header);
		getContentPane().add(show);
		getContentPane().add(branchNum);
		getContentPane().add(branchNum_display);
		getContentPane().add(location);
		getContentPane().add(location_display);
		getContentPane().add(openingHours);
		getContentPane().add(openingHours_display);
		getContentPane().add(branches_header);
		getContentPane().add(branchesList);
		
		setSize(545,376);
	}
	/**
	 * function initialize the list of branches
	 */
	public void initializeList() {
		for(Branch branch : MainClass.branches_manager.getBranches()) {
			barnchesModel.addElement(branch.getNum_of_branch());
		}
	}
			
}
