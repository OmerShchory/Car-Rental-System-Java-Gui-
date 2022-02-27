/**
 * Class represents a person
 */
package model;
import java.io.Serializable;
import java.util.Objects;

/**
 * 
 * @author david and omer
 *
 */
public class Person implements Serializable  {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	/**
	 * email, type String is the email of the person
	 */
	private String email;
	/**
	 * password, type String is the password of the person
	 */
	private String password;
	
	
	/**
	 * constructor
	 * @param email, type String is the email of the person
	 * @param password, type String is the password of the person
	 */
	public Person(String email, String password) {
		this.setEmail(email);
		this.setPassword(password);
	}

	
	//getters and setters

	/**
	 * function gets the email of the person
	 * @return email, type String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * function sets the email of the person
	 * @param email, type String
	 */
	public void setEmail(String email) { 
			this.email = email;
	}

	/**
	 * function gets the password of the person
	 * @return password, type String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * function sets the password of the person
	 * @param password, type String
	 */
	public void setPassword(String password) {  //adding a check for validation of password
			this.password = password;
	}

	
	/**
	 * function to string of the class. 
	 */
	//to string
	@Override
	public String toString() {
		return "Person [email=" + email + ", password=" + password + "]";
	}

	/**
	 * function hash code of the class
	 */
	@Override
	public int hashCode() {
		return Objects.hash(email, password);
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
		Person other = (Person) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password);
	}
	
}
