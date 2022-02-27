/**
 * Class represents branches manager with all the branches in the system
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
public class BranchesManager implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * branches, type  List<Branch> represents all the branches in the system
	 */
	private List<Branch> branches; //all the branches in the system
	
	/**
	 * constructor
	 */
	public BranchesManager() {
		this.branches = new ArrayList<Branch>(); //list of all branches
	}
	
	//functions
	
	/**
	 * function add branch to branches list
	 * @param branch, type branch is the branch to add the system.
	 */
	public void add_branch(Branch branch) {
		this.branches.add(branch);
	}

	/**
	 * function gets the branches list
	 * @return branches, type List<Branch>.
	 */
	//Getters 
	public List<Branch> getBranches() {
		return branches;
	}
	/**
	 * function tostring of the class. 
	 */
	//toString(), hashCode() and aquals()
	@Override
	public String toString() {
		return "BranchesManager [branches=" + branches + "]";
	}
	/**
	 * function hashcode of the class
	 */
	@Override
	public int hashCode() {
		return Objects.hash(branches);
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
		BranchesManager other = (BranchesManager) obj;
		return Objects.equals(branches, other.branches);
	}
	
}
