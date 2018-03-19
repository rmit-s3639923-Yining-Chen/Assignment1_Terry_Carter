/**
* this is a class which add a relationship 
*
* @version 1.00 17 March 2018
* @author Tianyu Tan(Terry)
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddRelationship extends Driver implements ICommander{

	private String name_1;
	private String name_2;
	private String relationship;

	
	private String personName;
	private String message;
	private boolean under16;
	
	public AddRelationship(Scanner reader) {		
		super("Add A Relationship",reader);
	}

	//normal use for users
	@Override
	public void Input(ArrayList<Person> ps, ArrayList<Relationship> rs) {
		//reset exception status
		super.setException(false);
		// print notice
		System.out.println("Please input person1, person2 and the relationship between them. e.g. Carter Terry Friend");
		//get command line from user
		super.setInputString(super.getReader().nextLine());
		
		//split commander to parts
		try 
		{
			super.setParts(super.getInputString().split(" "));
			name_1 = super.getParts()[0].trim();
			name_2 = super.getParts()[1].trim();
			relationship = "";
			for(int i = 2; i < super.getParts().length; i++) {
				relationship += " " + super.getParts()[i].trim();
			}		
		} 
		catch (Exception e)
		{
			//set exception if there is
			super.setException(true);
		}
		Execute(ps,rs);
	}
	
	//let add father and mother relationship when user is under 16
	public void Input(ArrayList<Person> ps, ArrayList<Relationship> rs,String personName, String relationship, String message,boolean under16) {
		//reset exception status
		super.setException(false);
		this.under16 = under16;
		this.personName = personName;
		//notice 
		this.message = message;
		//print notice
		System.out.println(message);
		//get commander line from user
		super.setInputString(super.getReader().nextLine());
		
		//split commander to parts
		try 
		{
			super.setParts(super.getInputString().split(" "));
			name_1 = personName;
			name_2 = super.getParts()[0].trim();
			this.relationship = relationship;		
		} 
		catch (Exception e)
		{
			//set exception if there is
			super.setException(true);
		}
		Execute(ps,rs);
	}

	@Override
	public void Execute(ArrayList<Person> ps, ArrayList<Relationship> rs) {	
		//find the first person
		ArrayList<Person> p1 = (ArrayList<Person>)ps.stream().filter(e -> e.getName().equals(name_1)).collect(Collectors.toList());
		//find the second person
		ArrayList<Person> p2 = (ArrayList<Person>)ps.stream().filter(e -> e.getName().equals(name_2)).collect(Collectors.toList());
		//person not found
		if(p1.size() == 0 || p2.size() == 0) {
			// set exception and message when person cannot found
			super.setException(true);
			super.setExceptionMessage("Person cannot be found!\n");
		}else {
			//check age over 2
			if(p1.get(0).getAge()<=2 || p2.get(0).getAge()<=2) {
				// set exception and message when person is under 2
				super.setException(true);
				super.setExceptionMessage("Person age is small than 2 years old!\n");
			}else {	
				//check age under 16 and two person's age cannot out of 3 year
				if((p1.get(0).getAge()<=16 || p2.get(0).getAge()<=16) && Math.abs(p1.get(0).getAge() - p2.get(0).getAge())>=3 ) {
					// set exception and message when age out of 3
					super.setException(true);
					super.setExceptionMessage("person with age under 16 connected with older than 3 years!\n");
				}else {
					//check person is under 16 can only connect to a person under 16 too					
					if(!(p1.get(0).getAge()<=16 && p2.get(0).getAge()<=16)) {
						// set exception and message when person is elder than 16 	
						super.setException(true);
						super.setExceptionMessage("persons with age under 16 can only be connected with the persons under 16!\n");
					}else {											
						//ask operator if two teenagers	from the same family		
						System.out.println("Are the two persons from the same family? y/n");
						String opt = super.getReader().nextLine();
						if(opt.equals("y")) {
							super.setException(true);
							super.setExceptionMessage("Two teenagers under 16 from the same family cannot connected as friend!\n");
						}else {
							// add the relationship	
							Relationship r = new Relationship(name_1,name_2,relationship);
							rs.add(r);
						}
					}
					
				}
			}
		}
		DisplayResult(ps,rs);
	}

	@Override
	public void DisplayResult(ArrayList<Person> ps, ArrayList<Relationship> rs) {
		if(super.isException()) 
		{
			// if exception here 
			System.out.println(super.getExceptionMessage());
			if(this.under16) {
				//when person age small than 16, add mother or father
				Input(ps,rs,personName,relationship,message,under16);
			}			
		}
		else 
		{
			//print feedback when success
			System.out.println("Seccess to add a relationship.");
			System.out.println();
		}	
	}
	
	
	
}
