/**
 * Class represents a Branch of the rental company
 */
package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 * @author david and omer
 *
 */
public class Branch implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1232222222221231L;
	/**
	 * num_of_branch, type String is the number of the branch
	 */
	private String num_of_branch;
	/**
	 * locataion, type String is the location of the branch
	 */
	private String location; //assuming city
	/**
	 * opening_hours, type String is the opening hours of the branch
	 */
	private String opening_hours;
	/**
	 * cars, type List <Car> is the list cars in the branch
	 */
	private List <Car> cars;
	
	/**
	 * constructor
	 * @param num_of_branch, type String is the number of the branch.
	 * @param location, type String is the location of the branch.
	 * @param opening_hours, type String is the opening hours of the branch.
	 */
	public Branch(String num_of_branch, String location, String opening_hours) {
		this.num_of_branch = num_of_branch;
		this.location = location;
		this.opening_hours = opening_hours;
		this.cars = new ArrayList<>();
	}

	//getters and setters
	
	/**
	 * function gets the number of the branch
	 * @return num_of_branch, type String .
	 */
	public String getNum_of_branch() {
		return num_of_branch;
	}

	/**
	 * function sets the number of the branch
	 * @param num_of_branch, type String is the number of the branch to set.
	 */
	public void setNum_of_branch(String num_of_branch) {
		this.num_of_branch = num_of_branch;
	}
	/**
	 * function gets the location of the branch
	 * @return location, type String.
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * function sets the location of the branch
	 * @param location, type String.
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * function gets the opening hours of the branch
	 * @return opening_hours, type String.
	 */
	public String getOpening_hours() {
		return opening_hours;
	}
	
	/**
	 * function sets the opening hours of the branch
	 * @param opening_hours, type String.
	 */
	public void setOpening_hours(String opening_hours) {
		this.opening_hours = opening_hours;
	}
	/**
	 * function gets the list of cars  of the branch
	 * @return cars, type List<Car>.
	 */
	public List<Car> getCars() {
		return cars;
	}
	/**
	 * function sets the list of cars  of the branch
	 * @param cars, type List<Car>. 
	 */
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	//functions
	/**
	 * function adds car to cars list
	 * @param car, type Car
	 */
	public void addCar (Car car)
	{
		this.cars.add(car);
	}
	

	/**
	 * function hashcode of the class
	 */
	@Override
	public int hashCode() {
		return Objects.hash(location, num_of_branch, opening_hours);
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
		Branch other = (Branch) obj;
		return Objects.equals(location, other.location) && num_of_branch == other.num_of_branch
				&& Objects.equals(opening_hours, other.opening_hours);
	}
	
	/**
	 * function tostring of the class. 
	 */
	@Override
	public String toString() {
		return "Branch [num_of_branch=" + num_of_branch + ", location=" + location + ", opening_hours=" + opening_hours
				+ "]";
	}
	
	
	
}
