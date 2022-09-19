package FinalExam.Pet;

import java.io.*;

public class PetDemo {
	public static void main(String[] args) {
		String TEXT_DATA_FILE = "src/FinalExam/Pet/Pets.txt";
		String BINARY_DATA_FILE = "src/FinalExam/Pet/Pet.dat";

		Pets pets = new Pets(TEXT_DATA_FILE);

		// Print pets ArrayList<Pet>. Hint: must implement .toString()
		System.out.println(pets);

		// Find pet's information by name
		// Note: there are two Meow in pets. Print ArrayList elements
		for (Pet p : pets.find("Meow"))
			System.out.println(p);

		// Note: there is no Meowth in pets. Just print the ArrayList
		System.out.println(pets.find("Meowth") + "\n");

		// Find pet's information by age
		System.out.println(pets.find(1));
		System.out.println(pets.find(100) + "\n");

		pets.sortByName();
		System.out.println(pets);

		pets.sortByWeight();
		System.out.println(pets);

		System.out.println(pets.printReport());

		pets.writeToBinaryFile(BINARY_DATA_FILE);

		validatingBinaryFile(pets, BINARY_DATA_FILE);
	}

	private static void validatingBinaryFile(Pets pets, String filename) {
		try {
			ObjectInputStream iStream = new ObjectInputStream(new FileInputStream(filename));
			while (true) {
				System.out.println((Pet) iStream.readObject());
			}
		} catch (IOException | ClassNotFoundException e) {
		}
	}
}

/*
 * Provided: PetDemo.java, Pets.txt The PetDemo.java will create an object of
 * Pets. The Pets reads Pets.txt as a collection of Pet objects.
 * 
 * Submit: Pet.java, Pets.java The Pet.java is similar to Listing 6.1, but can
 * be simpler. Its three attributes are name, age and weight. You may want to
 * have one overloaded constructor accepting values for the three attributes to
 * initialize the Pet object. You will need accessor method for each attribute.
 * You will need a toString() method returning information of the Pet object.
 * 
 * The Pets.java has only one attribute pets. You will use ArrayList<Pet> to
 * hold all pets data read from supplied text file.
 * 
 * A find method receives pet name as Sting to find pet(s) by name. The method
 * returns ArrayList<Pet>.
 * 
 * Another find method receives pet age as an integer to find pet(s) by age. The
 * method returns ArrayList<Pet>.
 * 
 * A void type method to sort the pets by name. The pets attribute will be
 * updated as sorted.
 * 
 * A void type method to sort the pets by weight. The pets attribute will be
 * updated as sorted.
 * 
 * A printReport method returns a String showing number and percentage of each
 * age group.
 * 
 * A writeToBinaryFile method receives a String as filename.
 * 
 * A toString method returns the pets as one single String.
 */

/*
 * Sample Output:
 * 
Name: Dash, Age: 3, Weight: 18.0
Name: Woof, Age: 9, Weight: 15.5
Name: Meow, Age: 7, Weight: 8.0
Name: Froggy, Age: 1, Weight: 1.0
Name: Moo, Age: 5, Weight: 200.0
Name: Kitty, Age: 6, Weight: 9.5
Name: Meow, Age: 2, Weight: 4.6
Name: Tweety, Age: 8, Weight: 1.5
Name: Squirrel, Age: 2, Weight: 1.2
Name: Bear, Age: 10, Weight: 400.0
Name: Racoon, Age: 4, Weight: 12.5
Name: Fox, Age: 4, Weight: 5.0
Name: Hamster, Age: 1, Weight: 0.5
Name: Duck, Age: 2, Weight: 1.3

Name: Meow, Age: 7, Weight: 8.0
Name: Meow, Age: 2, Weight: 4.6
[]

[Name: Froggy, Age: 1, Weight: 1.0, Name: Hamster, Age: 1, Weight: 0.5]
[]

Name: Bear, Age: 10, Weight: 400.0
Name: Dash, Age: 3, Weight: 18.0
Name: Duck, Age: 2, Weight: 1.3
Name: Fox, Age: 4, Weight: 5.0
Name: Froggy, Age: 1, Weight: 1.0
Name: Hamster, Age: 1, Weight: 0.5
Name: Kitty, Age: 6, Weight: 9.5
Name: Meow, Age: 7, Weight: 8.0
Name: Meow, Age: 2, Weight: 4.6
Name: Moo, Age: 5, Weight: 200.0
Name: Racoon, Age: 4, Weight: 12.5
Name: Squirrel, Age: 2, Weight: 1.2
Name: Tweety, Age: 8, Weight: 1.5
Name: Woof, Age: 9, Weight: 15.5

Name: Hamster, Age: 1, Weight: 0.5
Name: Froggy, Age: 1, Weight: 1.0
Name: Squirrel, Age: 2, Weight: 1.2
Name: Duck, Age: 2, Weight: 1.3
Name: Tweety, Age: 8, Weight: 1.5
Name: Meow, Age: 2, Weight: 4.6
Name: Fox, Age: 4, Weight: 5.0
Name: Meow, Age: 7, Weight: 8.0
Name: Kitty, Age: 6, Weight: 9.5
Name: Racoon, Age: 4, Weight: 12.5
Name: Woof, Age: 9, Weight: 15.5
Name: Dash, Age: 3, Weight: 18.0
Name: Moo, Age: 5, Weight: 200.0
Name: Bear, Age: 10, Weight: 400.0

There are 6 (42.86%) under five pounds.
There are 3 (21.43%) between five and ten pounds.
There are 5 (35.71%) more than ten pounds.

Name: Hamster, Age: 1, Weight: 0.5
Name: Froggy, Age: 1, Weight: 1.0
Name: Squirrel, Age: 2, Weight: 1.2
Name: Duck, Age: 2, Weight: 1.3
Name: Tweety, Age: 8, Weight: 1.5
Name: Meow, Age: 2, Weight: 4.6
Name: Fox, Age: 4, Weight: 5.0
Name: Meow, Age: 7, Weight: 8.0
Name: Kitty, Age: 6, Weight: 9.5
Name: Racoon, Age: 4, Weight: 12.5
Name: Woof, Age: 9, Weight: 15.5
Name: Dash, Age: 3, Weight: 18.0
Name: Moo, Age: 5, Weight: 200.0
Name: Bear, Age: 10, Weight: 400.0

 * 
 */



// Topics to study:
// Read inputs from text file 
// Parse comma separated values (CSV) file
// Using ArrayList<> to store objects
// Reading elements from ArrayList<>.
// Using generics as a type parameter
// Perform sort using Comparable interface
// Output objects to binary file for store and use of Serializable
// Use of try...catch... and Exceptions
// Use of toString() and overriding
// Overloading methods
// Use of DecimalFormat. Hint: see textbook appendix 4 
// Use of Java packages
