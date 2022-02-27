/**
 * Class represents frame for a customer car rental
 */
package view;
import model.*;
import controller.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.*;

/**
 * 
 * @author david and omer
 *
 */
public class CustomerRent extends JFrame{
	private static final long serialVersionUID = 122231L;
	/**
	 * day1, type JLabel is the day 1 label
	 */
	private JLabel day1;
	/**
	 * day1_choice, type Choice is the day 1 choice
	 */
	private Choice day1_choice;
	/**
	 * month1, type JLabel is the month1 label
	 */
	private JLabel month1;
	/**
	 * month1_choice, type Choice is the month1 choice
	 */
	private Choice month1_choice;
	/**
	 * year1, type JLabel is the year1 label
	 */
	private JLabel year1;
	/**
	 * year1_choice, type Choice is the year 1 choice
	 */
	private Choice year1_choice;
	/**
	 * day2, type JLabel is the day2 label
	 */
	private JLabel day2;
	/**
	 * day2_choice, type Choice is the day2 choice
	 */
	private Choice day2_choice;
	/**
	 * month2, type JLabel is the month2 label
	 */
	private JLabel month2;
	/**
	 * month2_choice, type Choice is the month2 choice
	 */
	private Choice month2_choice;
	/**
	 * year2, type JLabel is the year2 label
	 */
	private JLabel year2;
	/**
	 * year2_choice, type Choice is the year2 choice
	 */
	private Choice year2_choice;
	/**
	 * header, type JLabel is the header label
	 */
	private JLabel header;
	/**
	 * by_branch, type JLabel is the by branch label
	 */
	private JLabel by_branch;
	/**
	 * by_branch_choice, type Choice is the by branch choice
	 */
	private Choice by_branch_choice;
	/**
	 * by_category, type JLabel is the by category label
	 */
	private JLabel by_category;
	/**
	 * by_category_choice, type Choice is the by category choice choice
	 */
	private Choice by_category_choice;
	/**
	 * by_model, type JLabel is the by model label
	 */
	private JLabel by_model;
	/**
	 * by_model_choice, type Choice is the by model choice choice
	 */
	private Choice by_model_choice;
	/**
	 * by_production_year, type JLabel is the by production year label
	 */
	private JLabel by_production_year;
	/**
	 * by_production_year_choice, type Choice is the by production year choice
	 */
	private Choice by_production_year_choice;
	/**
	 * show_btn, type JButton is the show button
	 */
	private JButton show_btn;
	/**
	 * select_car, type JButton is the select car button
	 */
	private JButton select_car;
	/**
	 * list_of_cars, type JList<String> is the list of available cars for rental
	 */
	private JList<String> list_of_cars;
	/**
	 * cars_model, type DefaultListModel<String> is the cars model list
	 */
	private DefaultListModel<String> cars_model;
	/**
	 * user_selected_car, type Car is the car the user selected
	 */
	public static Car user_selected_car;
	/**
	 * formatter, type DateTimeFormatter is the date format
	 */
	public static DateTimeFormatter formatter;
	/**
	 * date_start_string, type String is the starting date of rental
	 */
	public static String date_start_string;
	/**
	 * date_end_string, type String is the end date of rental
	 */
	public static String date_end_string;
	/**
	 * date_start_LD, type LocalDate is the starting date of rental
	 */
	public static LocalDate date_start_LD;
	/**
	 * date_end_LD, type LocalDate is the end date of rental
	 */
	public static LocalDate date_end_LD;



	/**
	 * Constructor
	 */
	public CustomerRent() {
		super("CustomerRent");
		setResizable(false);
		getContentPane().setBackground(new Color(95, 158, 160));
		getContentPane().setFont(new Font("Open Sans", Font.BOLD, 13));
		setTitle("Rent a Car");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CustomerRent.class.getResource("/IMAGES/car ICON.png")));
		formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		select_car = new JButton("Select Car");
		select_car.setBackground(new Color(0, 0, 139));
		select_car.setForeground(new Color(255, 255, 255));
		select_car.setFont(new Font("Open Sans", Font.BOLD, 13));
		select_car.setBounds(418, 384, 109, 37);
		header = new JLabel("Please choose your rental details:");
		header.setForeground(new Color(255, 192, 203));
		header.setFont(new Font("Open Sans", Font.BOLD, 16));
		header.setBounds(150, 16, 301, 19);
		by_branch = new JLabel("branch number: ");
		by_branch.setFont(new Font("Open Sans", Font.BOLD, 13));
		by_branch.setBounds(64, 164, 121, 14);
		by_branch_choice = new Choice();
		by_branch_choice.setBounds(192, 164, 139, 20);
		by_category = new JLabel("car category: ");
		by_category.setFont(new Font("Open Sans", Font.BOLD, 13));
		by_category.setBounds(64, 218, 119, 14);
		by_category_choice = new Choice();
		by_category_choice.setBounds(192, 222, 139, 20);
		by_model = new JLabel("car model: ");
		by_model.setFont(new Font("Open Sans", Font.BOLD, 13));
		by_model.setBounds(79, 248, 104, 14);
		by_model_choice = new Choice();
		by_model_choice.setBounds(192, 253, 139, 20);
		by_production_year = new JLabel("year of production: ");
		by_production_year.setFont(new Font("Open Sans", Font.BOLD, 13));
		by_production_year.setBounds(48, 192, 139, 14);
		by_production_year_choice = new Choice();
		by_production_year_choice.setBounds(192, 191, 139, 20);
		show_btn = new JButton("Show Matching Cars");
		show_btn.setBackground(new Color(0, 0, 139));
		show_btn.setForeground(new Color(255, 255, 255));
		show_btn.setFont(new Font("Open Sans", Font.BOLD, 13));
		show_btn.setBounds(79, 384, 169, 37);
		day1 = new JLabel("Start Date   D: ");
		day1.setFont(new Font("Open Sans", Font.BOLD, 13));
		day1.setBounds(10, 51, 94, 14);
		day1_choice = new Choice();
		day1_choice.setBounds(110, 51, 76, 24);
		day2 = new JLabel("End Date   D: ");
		day2.setFont(new Font("Open Sans", Font.BOLD, 13));
		day2.setBounds(10, 112, 90, 14);
		day2_choice = new Choice();
		day2_choice.setBounds(110, 112, 74, 24);
		month1 = new JLabel("M: ");
		month1.setFont(new Font("Open Sans", Font.BOLD, 13));
		month1.setBounds(207, 46, 28, 24);
		month1_choice = new Choice();
		month1_choice.setBounds(241, 51, 74, 24);
		month2 = new JLabel("M: ");
		month2.setFont(new Font("Open Sans", Font.BOLD, 13));
		month2.setBounds(209, 112, 26, 24);
		month2_choice = new Choice();
		month2_choice.setBounds(241, 112, 74, 24);
		year1 = new JLabel("Y: ");
		year1.setFont(new Font("Open Sans", Font.BOLD, 13));
		year1.setBounds(337, 51, 15, 24);
		year1_choice = new Choice();
		year1_choice.setBounds(358, 51, 84, 24);
		year2 = new JLabel("Y: ");
		year2.setFont(new Font("Open Sans", Font.BOLD, 13));
		year2.setBounds(337, 112, 15, 24);
		year2_choice = new Choice();
		year2_choice.setBounds(358, 112, 84, 24);
		cars_model = new DefaultListModel<>();
   		list_of_cars  = new JList <String>(cars_model);
   		list_of_cars.setForeground(new Color(233, 150, 122));
   		list_of_cars.setFont(new Font("Open Sans", Font.BOLD, 11));
   		list_of_cars.setBackground(new Color(32, 178, 170));
   		list_of_cars.setBounds(414, 164, 113, 198);
   		//what happens when show button is pressed	
   		show_btn.addActionListener(new ActionListener() {  
	            public void actionPerformed(ActionEvent e) {
	   			cars_model.clear();
	   			date_start_string = day1_choice.getSelectedItem() + "-" + month1_choice.getSelectedItem() + "-" + year1_choice.getSelectedItem();
   			    date_end_string = day2_choice.getSelectedItem() + "-" + month2_choice.getSelectedItem() + "-" + year2_choice.getSelectedItem();
   			    date_start_LD = LocalDate.parse(date_start_string, formatter);
   			    date_end_LD = LocalDate.parse(date_end_string, formatter);
   			    
   			    //if the order of dates is not logical
   			 if(!(date_start_LD.isBefore(date_end_LD) || date_start_LD.isEqual(date_end_LD)))
				{
	   				JOptionPane.showMessageDialog(null, "The starting date cannot be after the ending date of the rental.", "Message Frame", JOptionPane.ERROR_MESSAGE);
	   				return;
				}
           		initializeList();
           		list_of_cars.setModel(cars_model);
                select_car.setVisible(true);
	            }  
	         });
		//what happens when the select car button is pressed		
		select_car.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e)
            {
            	//if there are no cars in the system
            	if(MainClass.cars_manager.getCars().isEmpty()) {
   				 JOptionPane.showMessageDialog(null, "No cars in the system", "Message Frame", JOptionPane.ERROR_MESSAGE);
   		         select_car.setVisible(false);
   				 //cars_model.clear();
   				 return;
            	}
            	if(cars_model.isEmpty()) {
   				 JOptionPane.showMessageDialog(null, "No cars matching the requests in the system", "Message Frame", JOptionPane.ERROR_MESSAGE);
   		         select_car.setVisible(false);
   				 //cars_model.clear();
   				 return;
            	}                
            	if(list_of_cars.getSelectedIndex() != -1)
                {  
                	for(Car c : MainClass.cars_manager.getCars()) 
                	{
                		if(c.getCarNumber().equals(list_of_cars.getSelectedValue())) 
                		{
                			user_selected_car = new Car();
                			user_selected_car = c;  
                			 date_start_string = day1_choice.getSelectedItem() + "-" + month1_choice.getSelectedItem() + "-" + year1_choice.getSelectedItem();
                			 date_end_string = day2_choice.getSelectedItem() + "-" + month2_choice.getSelectedItem() + "-" + year2_choice.getSelectedItem();
                			 date_start_LD = LocalDate.parse(date_start_string, formatter);
                			 date_end_LD = LocalDate.parse(date_end_string, formatter);
                			
                		}
                	}
                	SelectedCar f = new SelectedCar();
					setVisible(false); //you can't see me!
					dispose(); //Destroy the JFrame object
 					f.setVisible(true);
                }
            } 
         });
		initializeday();
		initializemonth();
		initializeyear();
		initialize_years_List();
		initialize_models_List();
		initialize_Branches_List();
		initializeCategories();
		initialize();
	}

	//----------initializers----------//

	/**
	 * function initialize choice categories
	 */
	public void initializeCategories() {
		by_category_choice.add("Mini");
		by_category_choice.add("Sedan");
		by_category_choice.add("Executive");
		by_category_choice.add("suv");
	}
	
	/**
	 * function initialize branches list
	 */
	public void initialize_Branches_List()
	{
		for (Branch element : MainClass.branches_manager.getBranches()) 
		{
			int is_found = 0;
			for(int i = 0; i< by_branch_choice.getItemCount();i++) 
			{
				//if the branch is already in the list
				if(element.getNum_of_branch().equals(by_branch_choice.getItem(i)))
				{
					is_found = 1;
				}
			}
			//if the branch is not in the list already
			if(is_found == 0)
			{
				by_branch_choice.add(element.getNum_of_branch());
			}
		}
	}
	
	/**
	 * function initialize models list of cars
	 */
	public void initialize_models_List()
	{
		for (Car element : MainClass.cars_manager.getCars()) 
		{			
			int is_found = 0;
			for(int i = 0; i< by_model_choice.getItemCount();i++) 
			{
				//if the model is already in the list
				if(element.getModel().equals(by_model_choice.getItem(i)))
				{
					is_found = 1;
				}
			}
			//if the model is not in the list already
			if(is_found == 0)
			{
				by_model_choice.add(element.getModel());
			}
		}
		
	}
	/**
	 * function initialize years list
	 */		
	public void initialize_years_List()
	{
		for (Car element : MainClass.cars_manager.getCars()) 
		{
			int is_found = 0;
			for(int i = 0; i< by_production_year_choice.getItemCount();i++) 
			{
				//if the year is already in the list
				if(element.getProduction_Year().equals(by_production_year_choice.getItem(i)))
				{
					is_found = 1;
				}
			}
			//if the year is not in the list already
			if(is_found == 0)
			{
				by_production_year_choice.add(element.getProduction_Year());
			}
		}
		
	}
	/**
	 * function initialize the list of cars
	 */
	public void initializeList() {
		boolean is_found = false;
		for(Car car : MainClass.cars_manager.getCars())
		{ 
			if(by_branch_choice.getSelectedItem().equals(car.getBranch_related())) {
				if(CarCategory.valueOf(by_category_choice.getSelectedItem()).equals(car.getCategory())) {
					if(by_model_choice.getSelectedItem().equals(car.getModel())) {
						if(by_production_year_choice.getSelectedItem().equals(car.getProduction_Year())) {
							 date_start_string = day1_choice.getSelectedItem() + "-" + month1_choice.getSelectedItem() + "-" + year1_choice.getSelectedItem();
							 date_end_string = day2_choice.getSelectedItem() + "-" + month2_choice.getSelectedItem() + "-" + year2_choice.getSelectedItem();
							 date_start_LD = LocalDate.parse(date_start_string, formatter);
							 date_end_LD = LocalDate.parse(date_end_string, formatter);
							 // in case the current car is not booked at all
								if(car.getUnavailable_ranges_Dates().isEmpty()) 
								{
									is_found= true;
									cars_model.addElement(car.getCarNumber());
								}
								for(List<LocalDate> list : car.getUnavailable_ranges_Dates()) 
								{
									//checking if the car is available in the relevant dates
									if((list.get(0).isAfter(date_start_LD) && list.get(0).isAfter(date_end_LD)) || (list.get(1).isBefore(date_end_LD) && list.get(1).isBefore(date_start_LD))) 
									{
										is_found= true;
										cars_model.addElement(car.getCarNumber());
									}
								}
						}
					}
				}
			}
		}
		// in case no car was found
		if(is_found == false)
		{
				select_car.setVisible(false);
				JOptionPane.showMessageDialog(null, "No cars was found with this details.", "Message Frame", JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * function initialize choices of day
	 */
	public void initializeday() {
		for(int i=1;i<32;i++) {
			if(i >=1 && i<=9) {
				day1_choice.add("0"+String.valueOf(i));
				day2_choice.add("0"+String.valueOf(i));
			}
			else {
				day1_choice.add(String.valueOf(i));
				day2_choice.add(String.valueOf(i));
			}
		}
	}
	/**
	 * function initialize choices of month
	 */
	public void initializemonth() {
		for(int i=1;i<13;i++) {
			if(i >=1 && i<=9) {
				month1_choice.add("0"+String.valueOf(i));
				month2_choice.add("0"+String.valueOf(i));
			}
			else {
				month1_choice.add(String.valueOf(i));
				month2_choice.add(String.valueOf(i));
			}
		}
	}
	/**
	 * function initialize choices of year
	 */
	public void initializeyear() {
		for(int i=2022;i<2033;i++) { //range of years in the system for 10 years
			year1_choice.add(String.valueOf(i));
			year2_choice.add(String.valueOf(i));

		}
	}
	/**
	 * function initialize the frame components and adds them to the frame
	 */
	public void initialize() {
		getContentPane().setLayout(null);
		getContentPane().add(header);
		getContentPane().add(day1);
		getContentPane().add(day1_choice);
		getContentPane().add(month1);
		getContentPane().add(month1_choice);
		getContentPane().add(year1);
		getContentPane().add(year1_choice);
		getContentPane().add(day2);
		getContentPane().add(day2_choice);
		getContentPane().add(month2);
		getContentPane().add(month2_choice);
		getContentPane().add(year2);
		getContentPane().add(year2_choice);
		getContentPane().add(by_branch);
		getContentPane().add(by_branch_choice);
		getContentPane().add(by_category);
		getContentPane().add(by_category_choice);
		getContentPane().add(by_model);
		getContentPane().add(by_model_choice);
		getContentPane().add(by_production_year);
		getContentPane().add(by_production_year_choice);
		getContentPane().add(list_of_cars);
		getContentPane().add(show_btn);
		getContentPane().add(select_car);
        select_car.setVisible(false);
		setSize(611,471);
	}
	

}
