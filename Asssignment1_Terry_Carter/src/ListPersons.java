/**
* This is the class for the goal of print the persons' details
*
* @version 1.00 16 March 2018
* @author Tianyu Tan(Terry)
*/

import java.util.ArrayList;
import java.util.Scanner;

public class ListPersons extends Driver implements ICommander{

	private String ResultString;
	
	public ListPersons(Scanner reader) {
		super("List Persons", reader);
	}

	@Override
	public void Input(ArrayList<Person> ps, ArrayList<Relationship> rs) {
		// no input from user
		Execute(ps,rs);
		
	}

	@Override
	public void Execute(ArrayList<Person> ps, ArrayList<Relationship> rs) {
		ResultString = "";
		//user for loop to add the details to a string 
		System.out.println("Person List\n");
		for(int i = 0; i < ps.size(); i ++) {
			ResultString += "Person " + (i+1) + " is: \n";
			ResultString += "Name: " + ps.get(i).getName()+"\n" ;
			ResultString += "Age: " + ps.get(i).getAge()+"\n" ;
			ResultString += "Status: " + ps.get(i).getStatus()+"\n\n" ;
		}
		DisplayResult(ps,rs);
	}

	@Override
	public void DisplayResult(ArrayList<Person> ps, ArrayList<Relationship> rs) {
		System.out.print(ResultString);
		System.out.println();
	}

}
