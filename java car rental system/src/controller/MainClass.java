/**
 * Class represents main program
 */
package controller;
import view.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 
 * @author david and omer
 *
 */
public class MainClass {
	/**
	 * adminEmail, type String represents the admin email address
	 */
	final public static  String  adminEmail = "admin@admin.com";
	/**
	 * adminpassword, type String represents the admin password
	 */
	final public static String adminPassword = "123456";
	/**
	 * customer_Manager, type CustomerManager is the customer manager of the system.
	 */
	public static CustomerManager customer_Manager = new CustomerManager();
	/**
	 * branches_manager, type BranchesManager is the branches manger of the system.
	 */
	public static BranchesManager branches_manager = new BranchesManager();
	/**
	 * CustomerManager, type CarsManager is the cars manager of the system.
	 */
	public static CarsManager cars_manager = new CarsManager();

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Try to run the program, catch exceptions if occur;
		 */
		//Reading from "customer_Manager.txt" file to customer_Manager
		// Deserialization
        try
        {   
            // Reading the object from a file
            FileInputStream fileD = new FileInputStream("customer_Manager.txt");
            ObjectInputStream in = new ObjectInputStream(fileD);
            
            FileInputStream file_B = new FileInputStream("branches_Manager.txt");
            ObjectInputStream in_b = new ObjectInputStream(file_B);
            
            FileInputStream file_H = new FileInputStream("cars_Manager.txt");
            ObjectInputStream in_H = new ObjectInputStream(file_H);
              
            // Method for deserialization of object
            MainClass.customer_Manager = (CustomerManager)in.readObject();
            MainClass.branches_manager = (BranchesManager)in_b.readObject();
            MainClass.cars_manager = (CarsManager)in_H.readObject();

            in_b.close();
            file_B.close();
            in.close();
            fileD.close();
            in_H.close();
            file_H.close();
   
            System.out.println("Object has been deserialized ");
            
        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
          
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
        // open the progran main frame
		Opening_Frame mainFrame = new Opening_Frame();
		mainFrame.setResizable(false);
		mainFrame.setVisible(true);

	}

}
