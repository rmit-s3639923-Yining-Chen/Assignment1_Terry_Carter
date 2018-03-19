/**
* This is main function class
*
* @version 1.00 15 March 2018
* @author Tianyu Tan(Terry)
*/
import java.util.ArrayList;
import java.util.Scanner;

public class MiniNet {
	
	private static ArrayList<Person> persons = new ArrayList<Person>();
	private static ArrayList<Relationship> relationships = new ArrayList<Relationship>();
	private static Scanner reader = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//Initialize data for demo
		persons.add(new Person("Carter",17,"Working In KFC"));
		persons.add(new Person("Terry",15,"Working In Meyer"));
		persons.add(new Person("Lucy",25,"Working In Meyer"));
				
		//create user interface
		UserInterface ui = new UserInterface();
		
		//set the loop flag
		boolean quit = false; 
		
		do {
			//print menu
			ui.DisplayMenu();
			//get option from user
			int option = ui.InputOption(reader);
			switch(option) 
			{
				// option 1, add a person
				case 1:
					AddPerson p = new AddPerson(reader);
					p.Input(persons,relationships);
					break;
				// option 2, list persons	
				case 2:
					ListPersons list = new ListPersons(reader);
					list.Input(persons,relationships);
					break;
				// option 3, add a relationship	
				case 3:
					AddRelationship ap = new AddRelationship(reader);
					ap.Input(persons,relationships);
					break;
				// option 4, exit application
				case 4:
					reader.close();
					quit = true;
					System.out.println("Thanks for using MiniNet!");	
					break;
				default:
				// if the option out of range	
					System.out.println("Please input vaild option!");	
			}
		}while(!quit);
		System.exit(0);
	}

}
