/**
 * Class represents the admin frame of add a new branch to the system
 */
package view;
import model.*;
import controller.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;

/**
 * 
 * @author david and omer
 *
 */
public class SelectedCar extends JFrame{

	private static final long serialVersionUID = 1L;
	/**
	 * branch_header, type JLabel is the branch header of the frame
	 */
	private JLabel branch_header;
	/**
	 * category_header, type JLabel is the category header of the frame
	 */
	private JLabel category_header;
	/**
	 * model_header, type JLabel is the model header of the frame
	 */
	private JLabel model_header;
	/**
	 * production_y_header, type JLabel is the production y header of the frame
	 */
	private JLabel production_y_header;
	/**
	 * branch, type JLabel is the branch label
	 */
	private JLabel branch;
	/**
	 * category, type JLabel is the category label
	 */
	private JLabel category;
	/**
	 * model, type JLabel is the model label
	 */
	private JLabel model;
	/**
	 * production_y, type JLabel is the production year label
	 */
	private JLabel production_y; 
	/**
	 * sum, type JLabel is the sum label
	 */
	private JLabel sum;;
	/**
	 * sum_header, type JLabel is the sum header of the frame
	 */
	private JLabel sum_header; 
	/**
	 * confirm, type JButton is the confirm button
	 */
	private JButton confirm;
	/**
	 * cancel, type JButton is the cancel button
	 */
	private JButton cancel;
	
	/**
	 * Constructor
	 */
	public SelectedCar() {
		getContentPane().setBackground(new Color(0, 128, 128));
		setIconImage(Toolkit.getDefaultToolkit().getImage(SelectedCar.class.getResource("/IMAGES/car ICON.png")));
		setResizable(false);
		setTitle("Order Summery");
		branch_header = new JLabel("Branch of the car: ");
		branch_header.setFont(new Font("Open Sans", Font.BOLD, 13));
		branch_header.setBounds(65, 83, 129, 14);
		category_header = new JLabel("Category of the car: ");
		category_header.setFont(new Font("Open Sans", Font.BOLD, 13));
		category_header.setBounds(57, 133, 137, 14);
		model_header = new JLabel("Model of the car: ");
		model_header.setFont(new Font("Open Sans", Font.BOLD, 13));
		model_header.setBounds(70, 58, 119, 14);
		branch = new JLabel(CustomerRent.user_selected_car.getBranch_related());
		branch.setFont(new Font("Open Sans", Font.BOLD, 13));
		branch.setBounds(204, 83, 114, 14);
		category = new JLabel(CustomerRent.user_selected_car.getCategory().toString());
		category.setFont(new Font("Open Sans", Font.BOLD, 13));
		category.setBounds(204, 133, 102, 14);
		model = new JLabel(CustomerRent.user_selected_car.getModel());
		model.setFont(new Font("Open Sans", Font.BOLD, 13));
		model.setBounds(199, 58, 119, 14);
		production_y_header = new JLabel("Production year of the car: ");
		production_y_header.setFont(new Font("Open Sans", Font.BOLD, 13));
		production_y_header.setBounds(10, 108, 183, 14);
		production_y = new JLabel(CustomerRent.user_selected_car.getProduction_Year());
		production_y.setFont(new Font("Open Sans", Font.BOLD, 13));
		production_y.setBounds(204, 108, 71, 14);
		long numofDaysBetween = ChronoUnit.DAYS.between(CustomerRent.date_start_LD, CustomerRent.date_end_LD) + 1;
		long Price_total = numofDaysBetween * Long.parseLong(CustomerRent.user_selected_car.getPrice_per_day());
		String total_in_string = Long.toString(Price_total);
		sum = new JLabel(total_in_string); 
		sum.setForeground(new Color(240, 128, 128));
		sum.setFont(new Font("Open Sans", Font.BOLD, 13));
		sum.setBounds(214, 163, 43, 14);
		sum_header = new JLabel("Overall Price: ");
		sum_header.setForeground(new Color(240, 128, 128));
		sum_header.setFont(new Font("Open Sans", Font.BOLD, 13));
		sum_header.setBounds(85, 163, 114, 14);
		confirm = new JButton("CONFIRM");
		confirm.setBackground(new Color(25, 25, 112));
		confirm.setForeground(new Color(255, 255, 255));
		confirm.setFont(new Font("Articulate Extrabold", Font.BOLD, 13));
		confirm.setBounds(65, 202, 114, 37);
		cancel = new JButton("CANCEL");
		cancel.setBackground(new Color(255, 0, 0));
		cancel.setForeground(new Color(255, 255, 255));
		cancel.setFont(new Font("Articulate Extrabold", Font.BOLD, 13));
		cancel.setBounds(204, 202, 102, 37);
		//what happens when cancel is pressed
		cancel.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {	
				//close this form and open customer rent form
				setVisible(false);
				dispose();
				CustomerRent f = new CustomerRent();
				f.setVisible(true);
			}
			}
		);
		
		//what happens if confirm order is pressed
		confirm.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {	
				for(Car c: MainClass.cars_manager.getCars()) {
					if(CustomerRent.user_selected_car.equals(c)) {
						List<LocalDate> temp = new ArrayList<LocalDate>();
        				temp.add(CustomerRent.date_start_LD);
        				temp.add(CustomerRent.date_end_LD);
        				//close this form
        				c.getUnavailable_ranges_Dates().add(temp);
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
        					  
        					  //Saving branch manger after adding car to file
        					  FileOutputStream fileb=new FileOutputStream("branches_Manager.txt");    
        					  ObjectOutputStream outb=new ObjectOutputStream(fileb);    
        					  outb.writeObject(MainClass.branches_manager);    
        					  //closing the stream    
        					  outb.close();   
        					  System.out.println("branch manager has been serialized");        					  
        					  setVisible(false); //you can't see me!
        					  dispose(); //Destroy the JFrame object

        					  }
        				  catch(IOException ex)
        				  {ex.printStackTrace();}
  						JOptionPane.showMessageDialog(null, "Rental confirmed", "Message Frame", JOptionPane.PLAIN_MESSAGE);
        				setVisible(false);
        				dispose();
					}
				}

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
		getContentPane().add(branch_header);
		getContentPane().add(branch);
		getContentPane().add(category_header);
		getContentPane().add(category);
		getContentPane().add(model_header);
		getContentPane().add(model);
		getContentPane().add(production_y_header);
		getContentPane().add(production_y);
		getContentPane().add(sum_header);
		getContentPane().add(sum);
		getContentPane().add(confirm);
		getContentPane().add(cancel); 
		setSize(368,327);
	}
	
	
}
