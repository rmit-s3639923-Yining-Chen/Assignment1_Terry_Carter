import java.util.Scanner;

public class AddPerson extends Drive implements ICommander {
	
	private Person newPerson = new Person();
	private String name;
	private int age;
	private String status = "";
	public AddPerson(Scanner reader) {		
		super("Add a person",reader);
	}

	@Override
	public void Input() {
		// TODO Auto-generated method stub
		System.out.println("Please input person details. e.g. Carter 22 Working in KFC");
		super.setInputString(super.getReader().nextLine());
			
		try 
		{
			super.setParts(super.getInputString().split(" "));
			name = super.getParts()[0];
			age =  Integer.parseInt(super.getParts()[1]);
			status = "";
			for(int i = 2; i < super.getParts().length; i++) {
				status += super.getParts()[i];
			}		
		} 
		catch (Exception e)
		{
			super.setException(true);
		}
	}

	@Override
	public Object Execute() {
		// TODO Auto-generated method stub
		newPerson = new Person(name,age,status);
		return newPerson;
	}

	@Override
	public void DisplayResult() {
		// TODO Auto-generated method stub
		if(super.isException()) 
		{
			System.out.println("Please input correct format to add a person.");
			Input();
		}else 
		{
			System.out.println("Seccess to add a person.");
		}	
	}
	
}
