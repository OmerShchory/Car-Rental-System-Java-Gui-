/**
 * Class represents admin frame of add a new car to the system
 */

package view;
import model.*;
import controller.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.*;

/**
 * 
 * @author david and omer
 *
 */
public class AdminAddCar  extends JFrame {
	private static final long serialVersionUID = 134231L;
	/**
	 * header, type JLabel is the header of the frame
	 */
	private JLabel header;
	/**
	 * add_car_btn, type JButton is button for adding car
	 */
	private JButton add_car_btn;
	/**
	 * Car_num, type JLabel is car number label
	 */
	private JLabel Car_num;
	/**
	 * Car_num_input, type JTextField is the car number text input
	 */
	private JTextField Car_num_input;
	/**
	 * Production_Year, type JLabel is the Production Year label
	 */
	private JLabel Production_Year;
	/**
	 * Production_Year_input, type JTextField is the Production Year text input
	 */
	private JTextField Production_Year_input;
	/**
	 * Model, type JLabel is the label of the car model
	 */
	private JLabel Model;
	/**
	 * Model_input, type JTextField is the model text input
	 */
	private JTextField Model_input;
	/**
	 * sub_Model, type JLabel is the sub model label
	 */
	private JLabel sub_Model;
	/**
	 * sub_Model_input, type JTextField is the sub model text input
	 */
	private JTextField sub_Model_input;
	/**										
	 * gear_box, type JTextField is the gear box label
	 */
	private JLabel gear_box;
	/**
	 * gear_box_input, type JTextField is the gear box text input
	 */
	private JTextField gear_box_input;	
	/**
	 * price_per_day, type JLabel is the price per day label
	 */
	private JLabel price_per_day;
	/**
	 * price_per_day_input, type JTextField price per day text input
	 */
	private JTextField price_per_day_input;
	/**
	 * category_lbl, type JLabel is category label
	 */
	private JLabel category_lbl;
	/**
	 * category, type Choice is the category choice
	 */
	private Choice category;
	/**
	 * belong_to_branch, type JLabel is the belong to branch label
	 */
	private JLabel belong_to_branch;
	/**
	 * branches_list, type JLabel is the branches list choice
	 */
	private Choice branches_list;
	
	/**
	 * constructor
	 */
	public AdminAddCar() {
		super("AdminAddCar");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminAddCar.class.getResource("/IMAGES/car ICON.png")));
		getContentPane().setBackground(new Color(95, 158, 160));
		setResizable(false);
		setTitle("Add New Car");
		header = new JLabel("Please enter the following details for the new car: ");
		header.setForeground(new Color(165, 42, 42));
		header.setFont(new Font("Open Sans", Font.BOLD, 16));
		header.setBounds(32, 48, 408, 34);
		add_car_btn = new JButton("Add Car");
		add_car_btn.setFont(new Font("Articulate Extrabold", Font.BOLD, 13));
		add_car_btn.setBackground(new Color(25, 25, 112));
		add_car_btn.setForeground(new Color(255, 255, 255));
		add_car_btn.setBounds(188, 404, 166, 34);
		category_lbl = new JLabel("Category: ");
		category_lbl.setFont(new Font("Open Sans", Font.BOLD, 13));
		category_lbl.setBounds(93, 307, 90, 19);
		category = new Choice();
		category.setBounds(188, 306, 166, 20);
		Car_num = new JLabel("Car Number: ");
		Car_num.setFont(new Font("Open Sans", Font.BOLD, 13));
		Car_num.setBounds(76, 114, 107, 14);
		Car_num_input = new JTextField(20);
		Car_num_input.setFont(new Font("Open Sans", Font.BOLD, 13));
		Car_num_input.setBounds(188, 111, 166, 20);
		Production_Year = new JLabel("Production Year: ");
		Production_Year.setFont(new Font("Open Sans", Font.BOLD, 13));
		Production_Year.setBounds(57, 145, 126, 14);
		Production_Year_input = new JTextField(20);
		Production_Year_input.setFont(new Font("Open Sans", Font.BOLD, 13));
		Production_Year_input.setBounds(188, 142, 166, 20);
		Model = new JLabel("Model: ");
		Model.setFont(new Font("Open Sans", Font.BOLD, 13));
		Model.setBounds(105, 173, 78, 14);
		Model_input = new JTextField(20);
		Model_input.setFont(new Font("Open Sans", Font.BOLD, 13));
		Model_input.setBounds(188, 170, 166, 20);
		sub_Model = new JLabel("Sub Model: ");
		sub_Model.setFont(new Font("Open Sans", Font.BOLD, 13));
		sub_Model.setBounds(76, 205, 109, 14);
		sub_Model_input = new JTextField(20);
		sub_Model_input.setFont(new Font("Open Sans", Font.BOLD, 13));
		sub_Model_input.setBounds(188, 201, 166, 20);
		gear_box = new JLabel("Gear Box: ");
		gear_box.setFont(new Font("Open Sans", Font.BOLD, 13));
		gear_box.setBounds(89, 233, 94, 14);
		gear_box_input = new JTextField(20);
		gear_box_input.setFont(new Font("Open Sans", Font.BOLD, 13));
		gear_box_input.setBounds(188, 230, 166, 20);
		price_per_day = new JLabel("Price Per Day:     $ ");
		price_per_day.setFont(new Font("Open Sans", Font.BOLD, 13));
		price_per_day.setBounds(63, 267, 120, 17);
		price_per_day_input = new JTextField(20);
		price_per_day_input.setFont(new Font("Open Sans", Font.BOLD, 13));
		price_per_day_input.setBounds(188, 265, 166, 20);
		belong_to_branch = new JLabel("Branch of the car: ");
		belong_to_branch.setFont(new Font("Open Sans", Font.BOLD, 13));
		belong_to_branch.setBounds(57, 347, 126, 14);
		branches_list = new Choice();
		branches_list.setBounds(188, 347, 166, 20);
		initialize_Branches_List();
		initializeCategories();
		// what happens when pressing on the add car button
		add_car_btn.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//empty fields validation
				if(Car_num_input.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Car number field is empty", "Message Frame", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(Production_Year_input.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Production Year input field is empty", "Message Frame", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(Model_input.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Model field is empty", "Message Frame", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(sub_Model_input.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Sub Model field is empty", "Message Frame", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(gear_box_input.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Gear Box field is empty", "Message Frame", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(price_per_day_input.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Price per day  field is empty", "Message Frame", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				//data validation
				
				//checking car number contains only numbers and more then 6 digits
				if((!Car_num_input.getText().matches("[0-9]+")) ||Car_num_input.getText().length() < 6 ) {
				JOptionPane.showMessageDialog(null, "Invalid car number, car number can contain only numbers, and more then 6 digits", "Message Frame", JOptionPane.ERROR_MESSAGE);
				return;
				}
				
				//checking price per day contains only numbers and bigger then 0 
				if((!price_per_day_input.getText().matches("[0-9]+")) ||Integer.parseInt(price_per_day_input.getText()) <= 0) {
				JOptionPane.showMessageDialog(null, "Invalid price", "Message Frame", JOptionPane.ERROR_MESSAGE);
				return;
				}
				// in case car number is already in the system
				for(Car c :MainClass.cars_manager.getCars())
				{
					if(c.getCarNumber().equals(Car_num_input.getText()))
					{
						JOptionPane.showMessageDialog(null, "Car number is already in the system", "Message Frame", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				
				
				//after all the checks - if everything is valid, we can create new car 
				Car car = new Car(Car_num_input.getText(),Production_Year_input.getText(), Model_input.getText(),sub_Model_input.getText(), CarCategory.valueOf(category.getSelectedItem()),gear_box_input.getText(),price_per_day_input.getText(),branches_list.getSelectedItem());
				//add new car to cars Manager
				MainClass.cars_manager.add_car(car);
				
				//add car to relevant branch
				
				for(Branch b : MainClass.branches_manager.getBranches())
            	{
            		if(b.getNum_of_branch() == branches_list.getSelectedItem())
            		{
            			
            			b.addCar(car);
            			break;
            		}
            	}

				//writing the MainClass.cars_Manager after the add of a new cars "cars_Manager.txt"
				//Saving of object in a file
				/**
				 * Try to Save the car object in a file, catch exceptions if occur;
				 */
				  try{    
					  //Saving car object in a file
					  FileOutputStream file=new FileOutputStream("cars_Manager.txt");    
					  ObjectOutputStream out=new ObjectOutputStream(file);    
					  out.writeObject(MainClass.cars_manager);    
					  //closing the stream    
					  out.close();  
					  System.out.println("cars manager has been serialized");
					  
					  //Saving car manger after adding car to file
					  FileOutputStream fileb=new FileOutputStream("branches_Manager.txt");    
					  ObjectOutputStream outb=new ObjectOutputStream(fileb);    
					  outb.writeObject(MainClass.branches_manager);    
					  //closing the stream    
					  outb.close();   
					  System.out.println("branch manager has been serialized");
					  
					  JOptionPane.showMessageDialog(null, "Car was added successfully to the system", "Message Frame", JOptionPane.PLAIN_MESSAGE);
					  //hide and close the signUp form
					  setVisible(false); //you can't see me!
					  dispose(); //Destroy the JFrame object

					  }
				  catch(IOException ex)
				  {ex.printStackTrace();}					
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
		getContentPane().add(Car_num);
		getContentPane().add(Car_num_input);
		getContentPane().add(Production_Year);
		getContentPane().add(Production_Year_input);
		getContentPane().add(Model);
		getContentPane().add(Model_input);
		getContentPane().add(sub_Model);
		getContentPane().add(sub_Model_input);
		getContentPane().add(gear_box);
		getContentPane().add(gear_box_input);
		getContentPane().add(price_per_day);
		getContentPane().add(price_per_day_input);
		getContentPane().add(category_lbl);
		getContentPane().add(category);
		getContentPane().add(belong_to_branch);
		getContentPane().add(branches_list);
		getContentPane().add(add_car_btn);
		setSize(487,507);
	}
	
	/**
	 *function is adding all categories to the car categories
	 */
	public void initializeCategories() {
		category.add("Mini");
		category.add("Sedan");
		category.add("Executive");
		category.add("suv");
	}
	
	/**
	 * function is adding all branches to branches list
	 */
	public void initialize_Branches_List()
	{
		for (Branch element : MainClass.branches_manager.getBranches()) 
		{
			branches_list.add(element.getNum_of_branch());
		}
	}

}
