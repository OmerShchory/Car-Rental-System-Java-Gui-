/**
 * Class represents a customer in the system
 */
package model;
//import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;

/**
 * 
 * @author david and omer
 *
 */
public class Customer extends Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Fname, type String is the first name of the customer
	 */
	private String Fname;
	/**
	 * Lname, type String is the last name of the customer
	 */
	private String Lname;
	/**
	 * Id, type String is the Id of the customer
	 */
	private String Id;
	/**
	 * birthdate, type String is the birth date of the customer
	 */
	private String birthdate; 
	/**
	 * year_of_lisence, type String is the year of license of the customer
	 */
	private String year_of_lisence;
	
	
	/**
	 * constructor
	 * @param email, type String is the email of the customer
	 * @param password, type String is the password of the customer
	 * @param fname, type String is the first name of the customer
	 * @param lname, type String is the last name of the customer
	 * @param id, type String is the id of the customer
	 * @param birthdate, type String is the birth date of the customer
	 * @param year_of_lisence, type String is the year of license of the customer
	 */
	public Customer(String email, String password, String fname, String lname, String id, String birthdate, String year_of_lisence) {
		super(email, password);
		Fname = fname;
		Lname = lname;
		Id = id;
		this.birthdate = birthdate;
		this.year_of_lisence = year_of_lisence;
	}

	
	//getters and setters

	/**
	 * function gets the first name of the customer
	 * @return Fname, type String
	 */
	public String getFname() {
		return Fname;
	}
	
	/**
	 * function sets the first name of the customer
	 * @param fname, type String
	 */
	public void setFname(String fname) {
		Fname = fname;
	}

	/**
	 * function gets the last name of the customer
	 * @return Lname, type String
	 */
	public String getLname() {
		return Lname;
	}
	
	/**
	 * function sets the last name of the customer
	 * @param lname, type String
	 */
	public void setLname(String lname) {
		Lname = lname;
	}
	
	/**
	 * function gets the Id of the customer
	 * @return Id, type String
	 */
	public String getId() {
		return Id;
	}
	
	/**
	 * function sets the Id of the customer
	 * @param id, type String
	 */
	public void setId(String id) {
		Id = id;
	}
	
	/**
	 * function gets the birth date of the customer
	 * @return birthdate, type String
	 */
	public String getDate() {
		return birthdate;
	}
	
	/**
	 * function sets the birth date of the customer
	 * @param date,type String
	 */
	public void setDate(String date) {
		this.birthdate = date;
	}
	
	/**
	 * function gets the birth date of the customer
	 * @return year_of_lisence, type String
	 */
	public String getYear_of_lisence() {
		return year_of_lisence;
	}
	
	/**
	 * function gets the birth date of the customer
	 * @param year_of_lisence
	 */
	public void setYear_of_lisence(String year_of_lisence) {
		this.year_of_lisence = year_of_lisence;
	}

	/**
	 * function hashcode of the class
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(Fname, Id, Lname, birthdate, year_of_lisence);
		return result;
	}
	
	/**
	 * function equals of the class
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(Fname, other.Fname) && Id == other.Id && Objects.equals(Lname, other.Lname)
				&& Objects.equals(birthdate, other.birthdate) && year_of_lisence == other.year_of_lisence;
	}

	/**
	 * function to string of the class. 
	 */
	@Override
	public String toString() {
		return "Customer [Fname=" + Fname + ", Lname=" + Lname + ", Id=" + Id + ", birthdate=" + birthdate + ", year_of_lisence="
				+ year_of_lisence + "]";
	}
	
	
	
}
