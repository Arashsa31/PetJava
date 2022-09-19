/**
 * 
 */
package FinalExam.Pet;

import java.io.Serializable;
import java.util.Comparator;

/**
 * @author Arash
 *
 *         Its three attributes are name, age and weight. You may want to have
 *         one overloaded constructor accepting values for the three attributes
 *         to initialize the Pet object. You will need accessor method for each
 *         attribute. You will need a toString() method returning information of
 *         the Pet object.
 */
public class Pet implements Comparable, Serializable {
	// attributes
	private String name;
	private int age;
	private double weight;

	// default construction
	public Pet() {
		name = "no name";
		age = 0;
		weight = 0.0;
	}

	// overloaded constructor
	public Pet(String name, int age, double weight) {
		setName(name);
		setAge(age);
		setWeight(weight);
	}

	// mutators
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @param weight
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	// accessor
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @return weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @return Name, Age, Weight
	 */
	public String toString() {
		return  "Name: " + getName() + 
				", Age: " + getAge() + 
				", Weight: " + getWeight();
	}

	@Override
	public int compareTo(Object o) {
		return name.compareTo(((Pet) o).name);
	}
}