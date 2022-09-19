/**
 * 
 */
package FinalExam.Pet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Arash
 *
 *         The Pets reads Pets.txt as a collection of Pet objects. The Pets.java
 *         has only one attribute pets. You will use ArrayList<Pet> to hold all
 *         pets data read from supplied text file.
 * 
 *         A find method receives pet name as Sting to find pet(s) by name. The
 *         method returns ArrayList<Pet>.
 * 
 *         Another find method receives pet age as an integer to find pet(s) by
 *         age. The method returns ArrayList<Pet>.
 * 
 *         A void type method to sort the pets by name. The pets attribute will
 *         be //implement updated as sorted.
 * 
 *         A void type method to sort the pets by weight. The pets attribute
 *         will be //implement updated as sorted.
 * 
 *         A printReport method returns a String showing number and percentage
 *         of each age group.
 * 
 *         A writeToBinaryFile method receives a String as filename.
 * 
 *         A toString method returns the pets as one single String.
 */
public class Pets {
	// attribute
	ArrayList<Pet> pets;

	// overloaded constructor
	public Pets(String TEXT_DATA_FILE) {
		try {
			Scanner input = new Scanner(new File(TEXT_DATA_FILE));

			pets = new ArrayList<Pet>();

			while (input.hasNext()) {
				String[] csv = input.nextLine().split(",");

				String tempName = csv[0];
				int tempAge = Integer.parseInt(csv[1]);
				double tempWeight = Double.parseDouble(csv[2]);

				pets.add(new Pet(tempName, tempAge, tempWeight));
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage() + " exception thrown: \t" + TEXT_DATA_FILE + " file not found.");
		} catch (Exception e) {
			System.out.println(e.getMessage() + " exception thrown: \t" + TEXT_DATA_FILE + " not readable.");
		}
	}

	/**
	 * @param name
	 * @return pet object matching name
	 */

	public ArrayList<Pet> find(String name) {
		ArrayList<Pet> findByName = new ArrayList<Pet>();
		for (int i = 0; i < pets.size(); i++)
			if (name.equalsIgnoreCase(pets.get(i).getName()))
				findByName.add(pets.get(i));
		return findByName;
	}

	/**
	 * @param age
	 * @return pet object matching age
	 */
	public ArrayList<Pet> find(int age) {
		ArrayList<Pet> findByAge = new ArrayList<Pet>();
		for (int i = 0; i < pets.size(); i++)
			if (age == pets.get(i).getAge())
				findByAge.add(pets.get(i));
		return findByAge;
	}

	/**
	 * @return sorted ArrayList by name
	 */
	public void sortByName() {
		Collections.sort(pets);
		/*
		 * pets.sort(new Comparator<Pet>() {public int compare(Pet pet1, Pet pet2) 
		 * { return pet1.getName().compareTo(pet2.getName());
		 * }});
		 */
		/*
		 * Comparable interface -> implements compareTo -> Arrays.sort(arr);
		 * Comparator interface -> implements compare(o1, o2) -> ArrayList al; al.sort();
		 */
		/*
		 * pets.sort(new Comparator<Pet>() 
		 * 	{	// inner class
		 * 		public int compare (pet p1, Pet p2) 
		 * 			{return p1.getName().compareTo(p2.getName());
		 * 	;} 
		 * } 		
		 * );
		 */
//		pets.sort(whatever comparator) // supply the inner class in the (whatever comparator)
//		Arrays.sort(pets);
	}

	/**
	 * @return sorted ArrayList by weight
	 */
	public void sortByWeight() {		
		class PetSorter implements Comparator<Pet> {
			public int compare(Pet o1, Pet o2) {
				return (int) o1.getWeight() - (int) o2.getWeight(); // best to use  < or > because using double
			}
		}
		Comparator<Pet> petSorter = new PetSorter();
		Collections.sort(pets, petSorter);
		
//		Collections.sort(pets, 
//							new Comparator<Pet>() {
//								public int compare(Pet o1, Pet o2) {
//									return (int) o1.getWeight() - (int) o2.getWeight();
//								}
//							}
//						);
		
		/*
		 * pets.sort(new Comparator<Pet>() { public int compare(Pet pet1, Pet pet2) {
		 * if (pet1.getWeight() == pet2.getWeight())
		 * return 0;
		 * else if (pet1.getWeight() > pet2.getWeight()
		 * return 1;
		 * else return -1;
		 */
	}

	/**
	 * @return number and percentage of pets at certain weights
	 */
	public String printReport() {
		int belowFive = 0;
		int betweenFiveAndTen = 0;
		int aboveTen = 0;
		for (int i = 0; i < pets.size(); i++) {
			if (pets.get(i).getWeight() < 5)
				belowFive++;
			else if (pets.get(i).getWeight() >= 5 && pets.get(i).getWeight() <= 10)
				betweenFiveAndTen++;
			else
				aboveTen++;
		}

//		uses DecimalFormat
		DecimalFormat decimalFormatObject = new DecimalFormat("#0.0#%");
		return  "There are " + belowFive 		 + " (" + decimalFormatObject.format(((double) belowFive) / pets.size()) 		 + ") under five pounds.\n" + 
				"There are " + betweenFiveAndTen + " ("	+ decimalFormatObject.format(((double) betweenFiveAndTen) / pets.size()) + ") between five and ten pounds.\n" + 
				"There are " + aboveTen 		 + " (" + decimalFormatObject.format(((double) aboveTen) / pets.size()) 		 + ") more than ten pounds.\n";

//		uses String.format()
//		return 
//		"There are " + under5Pounds 	 + " (" + String.format("%.2f", ((double) under5Pounds) / pets.size() * 100) + "%) under five pounds.\n" + 
//		"There are " + between5_10Pounds + " (" + String.format("%.2f", ((double) between5_10Pounds) / pets.size() * 100) + "%) between five and ten pounds.\n" +
//		"There are " + over10Pounds 	 + " (" + String.format("%.2f", ((double) over10Pounds) / pets.size() * 100)	+ "%) more than ten pounds.";
	}

	/**
	 * @param fileName
	 */
	public void writeToBinaryFile(String fileName) {
		try {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName));
			for (int i = 0; i < pets.size(); i++)
				output.writeObject(pets.get(i));
			output.close();
			//do not need FileNotFoundException because this is a subclass of IOException
		} catch (FileNotFoundException e) { 
			System.out.println(e.getMessage() + " File not found exception");
		} catch (IOException e) {
			System.out.println(e.getMessage() + " IO Exception");
		}
	}

	/**
	 * @return each object
	 */
	public String toString() {
		String petInfo = "";
		for (int i = 0; i < pets.size(); i++) {
			petInfo += pets.get(i) + "\n";
		}
		return petInfo;
	}
}