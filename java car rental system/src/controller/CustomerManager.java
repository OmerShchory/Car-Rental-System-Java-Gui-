/**
 * Class represents customer manager with all the customers in the system
 */

package controller;
import model.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * 
 * @author david and omer
 *
 */
public class CustomerManager implements Serializable 
{

	private static final long serialVersionUID = 12311L;
	/**
	 * customers, type  List<Person> represents all the customers in the system
	 */
	private List<Person> customers;// admin is also in the list

	
	/**
	 * constructor
	 */
	public CustomerManager() 
	{
		this.customers = new ArrayList<Person>();
		Person admin = new Person(MainClass.adminEmail ,MainClass.adminPassword);//adding admin to customers
		this.customers.add(admin);
	}
	
	/**
	 * function add branch to branches list
	 * @param customer, type Customer is the customer to add the system.
	 */
	public void addCustomer (Customer customer)
	{
		this.customers.add(customer);
		//count++;
	}
	
	/**
	 *function gets the customers list
	 * @return customers, type List<Person>.
	 */
	// Getters 
	public List<Person> getCustomers() {
		return customers;
	}

	/**
	 * function hashcode of the class
	 */
	@Override
	public int hashCode() {
		return Objects.hash(customers);
	}

	/**
	 * function equals of the class
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerManager other = (CustomerManager) obj;
		return Objects.equals(customers, other.customers);
	}
	
	/**
	 * function tostring of the class. 
	 */
	@Override
	public String toString() {
		return "CustomerManager [customers=" + customers + "]";
	}

	
	
}
