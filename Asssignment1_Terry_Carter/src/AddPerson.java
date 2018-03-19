/**
* This is the class AddPerson which uses for the add person function.
*
* @version 1.00 17 March 2018
* @author Yining Chen
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddPerson extends Driver implements ICommander {
	private String name;
	private int age;
	private String status = "";
	public AddPerson(Scanner reader) {		
		super("Add A Person",reader);
	}

	// get input command from user
	@Override
	public void Input(ArrayList<Person> ps, ArrayList<Relationship> rs) {
		//reset exception
		super.setException(false);
		//print user message
		System.out.println("Please input person details. e.g. Carter 22 Working in KFC");
		//get input from user
		super.setInputString(super.getReader().nextLine());
			
		try 
		{
			//split user input to string array
			super.setParts(super.getInputString().split(" "));
			//get name
			name = super.getParts()[0].trim().toString();
			//get age
			age =  Integer.parseInt(super.getParts()[1].trim().toString());
			//get status from rest of string array
			status = "";
			for(int i = 2; i < super.getParts().length; i++) {
				status += " " + super.getParts()[i].trim().toString();
			}		
		} 
		catch (Exception e)
		{
			// if failed to process input, throw a exception 
			super.setException(true);
			super.setExceptionMessage("Please input vaild person details. e.g. Carter 22 Working in KFC");
		}
		Execute(ps,rs);
	}

	
	@Override
	public void Execute(ArrayList<Person> ps, ArrayList<Relationship> rs) {
		//find the person if is already
		ArrayList<Person> p1 = (ArrayList<Person>)ps.stream().filter(e -> e.getName().equals(name)).collect(Collectors.toList());
		if(p1.size() == 1) {
			super.setException(true);
			super.setExceptionMessage("Person has already here!\n");
		}else {
			//check age under 16
			if(age < 16) {
				AddRelationship ar = new AddRelationship(super.getReader());
				//let user input person's father name
				ar.Input(ps, rs, name, "Father and child", "Please input the person's father's name! e.g. Tonny", true);
				//let user input person's mother name
				ar.Input(ps, rs, name, "Mother and child", "Please input the person's Mother's name! e.g. Lucy", true);
			}else {
				Person newPerson = new Person(name,age,status);	
				ps.add(newPerson);
			}
		}
		//display result
		DisplayResult(ps,rs); 
	}

	@Override
	public void DisplayResult(ArrayList<Person> ps, ArrayList<Relationship> rs) {
		if(super.isException()) 
		{
			// print exception if has
			System.out.println(super.getExceptionMessage());
		}else 
		{
			// print feadback
			System.out.println("Seccess to add a person.");
			System.out.println();
		}	
	}
	
}
