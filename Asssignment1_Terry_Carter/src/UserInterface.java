/**
* This is User Interface
*
* @version 1.00 15 March 2018
* @author Yining Chen
*/
import java.util.Scanner;

public class UserInterface {
	
	public UserInterface() {}
	
	//print menu
	public void DisplayMenu() {
		//print the menu
		System.out.println("Welcome to MiniNet Menu");
		System.out.println("Powered by Terry and Carter");
		System.out.println("===================================");
		System.out.println("1. Add a person");		
		System.out.println("2. List everyone");	
		System.out.println("3. Add a relationship");	
	}
	
	//let user input options
	public int InputOption(Scanner reader) {
		int result = 0;
		System.out.print("\nEnter an option: ");	
		
		try 
		{
			//transfer option from string to string
			result = Integer.parseInt(reader.nextLine());
			System.out.println();
		} catch(Exception e) 
		{
			//print exception 
			System.out.println("Please input a number!");	
			InputOption(reader);
		}
		return result;		
	} 
	
	
}
