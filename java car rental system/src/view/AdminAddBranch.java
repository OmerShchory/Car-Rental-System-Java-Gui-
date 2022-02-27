/**
 * Class represents admin frame of add a new branch to the system
 */
package view;
import model.*;
import controller.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
//import java.util.*;
import java.util.regex.Pattern;
import javax.swing.*;

/**
 * 
 * @author david and omer
 *
 */
public class AdminAddBranch extends JFrame {
	private static final long serialVersionUID = 122231L;
	/**
	 * header, type JLabel is the header of the frame
	 */
	private JLabel header;
	/**
	 * num_branch, type JLabel is number of the branch label
	 */
	private JLabel num_branch;
	/**
	 * num_branch_input, type JTextField is number of the branch user text input
	 */
	private JTextField num_branch_input;
	/**
	 * opening_hours, type JLabel is opening hours of the branch label
	 */
	private JLabel opening_hours;
	/**
	 * location, type JLabel is location of the branch label
	 */
	private JLabel location;
	/**
	 * location_input, type JTextField is location of the branch user text input
	 */
	private JTextField location_input;
	/**
	 * add_branch, type JButton is the add branch button
	 */
	private JButton add_branch;
	/**
	 * startHour, type Choice start hour choice
	 */
	private Choice startHour;
	/**
	 * startMin, type Choice start minutes choice
	 */
	private Choice startMin;
	/**
	 * endHour, type Choice end hour choice
	 */
	private Choice endHour;
	/**
	 * endMin, type Choice end minutes choice
	 */
	private Choice endMin;


	/**
	 * Constructor
	 */
	public AdminAddBranch() {
		super("AdminAddBranch");
		setResizable(false);
		getContentPane().setBackground(new Color(95, 158, 160));
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminAddBranch.class.getResource("/IMAGES/car ICON.png")));
		setTitle("Add New Branch");
		startHour = new Choice();
		startMin = new Choice();
		endHour = new Choice();
		endMin = new Choice();
		header = new JLabel("Please enter the following details for the new branch: ");
		header.setForeground(new Color(233, 150, 122));
		header.setFont(new Font("Open Sans", Font.BOLD, 13));
		header.setBounds(20, 11, 377, 20);
		num_branch = new JLabel("Num of Branch: ");
		num_branch.setFont(new Font("Open Sans", Font.BOLD, 13));
		num_branch.setBounds(20, 57, 125, 14);
		num_branch_input = new JTextField(20);
		num_branch_input.setFont(new Font("Open Sans", Font.BOLD, 13));
		num_branch_input.setBounds(153, 57, 166, 20);
		location = new JLabel("Location: ");
		location.setFont(new Font("Open Sans", Font.BOLD, 13));
		location.setBounds(65, 128, 101, 14);
		location_input = new JTextField(20);
		location_input.setFont(new Font("Open Sans", Font.BOLD, 13));
		location_input.setBounds(153, 125, 166, 20);
		add_branch = new JButton("Add Branch");
		add_branch.setForeground(new Color(255, 255, 255));
		add_branch.setBackground(new Color(25, 25, 112));
		add_branch.setFont(new Font("Articulate Extrabold", Font.BOLD, 13));
		add_branch.setBounds(153, 187, 120, 43);
		// what happens when pressing add branch
		add_branch.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {	
				//empty fields validation
				if(num_branch_input.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Brabch Number field is empty", "Message Frame", JOptionPane.ERROR_MESSAGE);
					return;
				}

				if(location_input.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Location field is empty", "Message Frame", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				//data validation//
				
				//checking branch number contains only numbers
				if((!num_branch_input.getText().matches("[0-9]+"))) {
				JOptionPane.showMessageDialog(null, "Invalid branch number, branch number can contain only numbers", "Message Frame", JOptionPane.ERROR_MESSAGE);
				return;
				}
				//checking Location contains only alphbet letters
				if(!Pattern.matches("[a-zA-Z]+", location_input.getText())) {
					JOptionPane.showMessageDialog(null, "Invalid Location", "Message Frame", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				// in case branch number is already in the system
				for(Branch b :MainClass.branches_manager.getBranches())
				{
					if(b.getNum_of_branch().equals(num_branch_input.getText()))
					{
						JOptionPane.showMessageDialog(null, "Branch number is already in the system", "Message Frame", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				
				// opening hours summary string
				String opening_hours = startHour.getSelectedItem() + ":"+ startMin.getSelectedItem() + " - " +  endHour.getSelectedItem() + ":"+ endMin.getSelectedItem(); 
				//after all the checks - if everything is valid, we can create new branch 
				Branch branch = new Branch(num_branch_input.getText(), location_input.getText(), opening_hours);
				//add new customer to branch Manager
				MainClass.branches_manager.add_branch(branch);
				
				//writing the MainClass.branch_Manager after the add of a new customer "branches_Manager.txt"
				//Saving of object in a file
				/**
				 * Try to Save the branch object in a file, catch exceptions if occur;
				 */
				  try{    
		
					//Saving of object in a file
					  FileOutputStream file=new FileOutputStream("branches_Manager.txt");    
					  ObjectOutputStream out=new ObjectOutputStream(file);    
					  out.writeObject(MainClass.branches_manager);    
					  //closing the stream    
					  out.close();    
					  System.out.println("Object has been serialized");
					  
					  JOptionPane.showMessageDialog(null, "Branch was added successfully to the system", "Message Frame", JOptionPane.PLAIN_MESSAGE);
					  setVisible(false); //you can't see me!
					  dispose(); //Destroy the JFrame object

					  }
				  catch(IOException ex)
				  {ex.printStackTrace();}					
			}
			}
		);
		initializeHoure();
		initializeMins();
		initialize();
	}
	
	/**
	 * function initialize choice of hours
	 */
	public void initializeHoure() {
		for(int i=8;i<23;i++) { 
			if(i >=1 && i<=9) {
				startHour.add("0"+String.valueOf(i));
				endHour.add("0"+String.valueOf(i));
			}
			else {
				startHour.add(String.valueOf(i));
				endHour.add(String.valueOf(i));
			}

		}
	}
	
	/**
	 * function initialize choice of minutes
	 */
	public void initializeMins() {
		for(int i=0;i<60;i++) { //range of years in the system for 10 years
			if(i >=0 && i<=9) {
				startMin.add("0"+String.valueOf(i));
				endMin.add("0"+String.valueOf(i));
			}
			else {
				startMin.add(String.valueOf(i));
				endMin.add(String.valueOf(i));
			}
		}
	}
	
	/**
	 * function initialize the frame components and adds them to the frame
	 */
	public void initialize() {
		getContentPane().setLayout(null);
		getContentPane().add(header);
		getContentPane().add(num_branch);
		getContentPane().add(num_branch_input);
		getContentPane().add(location);
		getContentPane().add(location_input);
		getContentPane().add(add_branch);
		startHour.setBounds(153, 92, 47, 20);
		getContentPane().add(startHour);
		startMin.setBounds(216, 92, 47, 20);
		getContentPane().add(startMin);
		endHour.setBounds(295, 92, 43, 20);
		getContentPane().add(endHour);
		endMin.setBounds(352, 92, 45, 20);
		getContentPane().add(endMin);
		opening_hours = new JLabel("Opening Hours:                        :                     to                   :");
		opening_hours.setFont(new Font("Open Sans", Font.BOLD, 13));
		opening_hours.setBounds(32, 92, 363, 17);
		getContentPane().add(opening_hours);
		setSize(421,293);

	}
}
