/**
 * Class represents cars manager with all the cars in the system
 */
package controller;
import model.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 * @author david and omer
 *
 */
public class CarsManager implements Serializable
{
	private static final long serialVersionUID = 12315L;
	/**
	 * Cars, type List<Car> represents all the cars in the system.
	 */
	private List<Car> Cars; //all the cars in the system
	
	/**
	 * constructor
	 */
	public CarsManager() {
		this.Cars = new ArrayList<Car>(); //list of all card
	}

	//Getters
	
	/**
	 *  function gets the branches list
	 * @return
	 */
	public List<Car> getCars() {
		return Cars;
	}
	
	//functions
	/**
	 * function add car to branches list
	 * @param car, type Car is the car to add to the system.
	 */
	public void add_car(Car car)
	{
		this.Cars.add(car);
	}

	/**
	 * function hashcode of the class
	 */
	@Override
	public int hashCode() {
		return Objects.hash(Cars);
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
		CarsManager other = (CarsManager) obj;
		return Objects.equals(Cars, other.Cars);
	}
	/**
	 * function tostring of the class. 
	 */
	@Override
	public String toString() {
		return "CarsManager [Cars=" + Cars + "]";
	}
	


	
	
}
