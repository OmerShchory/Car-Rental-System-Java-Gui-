/**
 * Class represents a car int the system
 */
package model;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 * @author david and omer
 *
 */
public class Car implements Serializable{
	private static final long serialVersionUID = 13423L;
	//fields
	/**
	 * CarNumber, type String is the number of the car
	 */
	private String CarNumber;
	/**
	 * Production_Year, type String is the Production Year of the car
	 */
	private String Production_Year;
	/**
	 * Model, type String is the Model of the car
	 */
	private String Model;
	/**
	 * sub_Model, type String is the sub Model of the car
	 */
	private String sub_Model;
	/**
	 * category, type CarCategory is the category of  the car
	 */
	private CarCategory category;
	/**
	 * gear_box, type String is the gear box type of the car
	 */
	private String gear_box;
	/**
	 * price_per_day, type String is the price for a rental day in USD$
	 */
	private String price_per_day;
	/**
	 * branch_related, type String is branch that the car is related to
	 */
	private String branch_related;
	/**
	 * unavailable_ranges_Dates, type List<List<LocalDate>> is list of date that the car is unavailable in 
	 */
	private List<List<LocalDate>> unavailable_ranges_Dates;

	
	//constructors
	
	/**
	 *empty constructor
	 */
	public Car() {}
	
	/**
	 * constructor
	 * @param carNumber, type String is the number of the car
	 * @param production_Year, type String is the Production Year of the car
	 * @param model, type String is the Model of the car
	 * @param sub_Model, type String is the sub Model of the car
	 * @param category, type CarCategory is the category of  the car
	 * @param gear_box, type String is the gear box type of the car
	 * @param price_per_day, type String is the price for a rental day in USD$
	 * @param branch_related, type String is branch that the car is related to
	 */
	public Car(String carNumber, String production_Year, String model, String sub_Model, CarCategory category,
			String gear_box, String price_per_day, String branch_related) 
	{
		CarNumber = carNumber;
		Production_Year = production_Year;
		Model = model;
		this.unavailable_ranges_Dates = new ArrayList<List<LocalDate>>();
		this.sub_Model = sub_Model;
		this.category = category;
		this.gear_box = gear_box;
		this.price_per_day = price_per_day;
		this.branch_related = branch_related;
	}
	

	//getters and setters
	
	/**
	 * function gets the CarNumber of the car
	 * @return CarNumber, type String
	 */
	public String getCarNumber() {
		return CarNumber;
	}
	/**
	 * function sets the car Number
	 * @param carNumber, type String
	 */
	public void setCarNumber(String carNumber) {
		CarNumber = carNumber;
	}
	/**
	 * function gets the Production Year of the car
	 * @return Production_Year, type String
	 */
	public String getProduction_Year() {
		return Production_Year;
	}
	/**
	 * function sets the production_Year of the car
	 * @param production_Year, type String
	 */
	public void setProduction_Year(String production_Year) {
		Production_Year = production_Year;
	}
	/**
	 * function gets the model of the car
	 * @return model, type String
	 */
	public String getModel() {
		return Model;
	}
	/**
	 * function sets the model of the car 
	 * @param model, type String
	 */
	public void setModel(String model) {
		Model = model;
	}
	/**
	 * function gets the getSub_Model of the car
	 * @return sub_Model, type String
	 */
	public String getSub_Model() {
		return sub_Model;
	}
	/**
	 * function sets the sub model of the car 
	 * @param sub_Model, type String
	 */
	public void setSub_Model(String sub_Model) {
		this.sub_Model = sub_Model;
	}
	/**
	 * function gets the category of the car
	 * @return category, type CarCategory
	 */
	public CarCategory getCategory() {
		return category;
	}
	/**
	 * function sets the category of the car 
	 * @param category, type CarCategory
	 */
	public void setCategory(CarCategory category) {
		this.category = category;
	}
	/**
	 * function gets the gear box type of the car
	 * @return gear_box, type String
	 */
	public String getGear_box() {
		return gear_box;
	}
	/**
	 * function sets the gear box of the car 
	 * @param gear_box, type String
	 */
	public void setGear_box(String gear_box) {
		this.gear_box = gear_box;
	}
	/**
	 * function gets the price per rental day of the car
	 * @return price_per_day, type String.
	 */
	public String getPrice_per_day() {
		return price_per_day;
	}
	/**
	 * function sets the price per day of the car 
	 * @param price_per_day,String, type String
	 */
	public void setPrice_per_day(String price_per_day) {
		this.price_per_day = price_per_day;
	}

	/**
	 * function gets the unavailable ranges Dates of the car for rent
	 * @return unavailable_ranges_Dates, type List<List<LocalDate>>
	 */
	public List<List<LocalDate>> getUnavailable_ranges_Dates() {
		return unavailable_ranges_Dates;
	}
	/**
	 * function sets the unavailable ranges Dates of the car 
	 * @param unavailable_ranges_Dates, type List<List<LocalDate>>
	 */
	public void setUnavailable_ranges_Dates(List<List<LocalDate>> unavailable_ranges_Dates) {
		this.unavailable_ranges_Dates = unavailable_ranges_Dates;
	}
	/**
	 * function gets the branch related of the car
	 * @return branch_related, type String
	 */
	public String getBranch_related() {
		return branch_related;
	}
	/**
	 * function sets the branch related of the car 
	 * @param branch_related, type String
	 */
	public void setBranch_related(String branch_related) {
		this.branch_related = branch_related;
	}

	/**
	 * function hashcode of the class
	 */
	@Override
	public int hashCode() {
		return Objects.hash(CarNumber, Model, Production_Year, branch_related, category, gear_box, price_per_day,
				sub_Model, unavailable_ranges_Dates);
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
		Car other = (Car) obj;
		return Objects.equals(CarNumber, other.CarNumber) && Objects.equals(Model, other.Model)
				&& Objects.equals(Production_Year, other.Production_Year)
				&& Objects.equals(branch_related, other.branch_related) && category == other.category
				&& Objects.equals(gear_box, other.gear_box) && Objects.equals(price_per_day, other.price_per_day)
				&& Objects.equals(sub_Model, other.sub_Model)
				&& Objects.equals(unavailable_ranges_Dates, other.unavailable_ranges_Dates);
	}
	
	/**
	 * function tostring of the class. 
	 */
	@Override
	public String toString() {
		return "Car [CarNumber=" + CarNumber + ", Production_Year=" + Production_Year + ", Model=" + Model
				+ ", sub_Model=" + sub_Model + ", category=" + category + ", gear_box=" + gear_box + ", price_per_day="
				+ price_per_day + ", branch_related=" + branch_related + ", unavailable_ranges_Dates="
				+ unavailable_ranges_Dates + "]";
	}
	
	
}
