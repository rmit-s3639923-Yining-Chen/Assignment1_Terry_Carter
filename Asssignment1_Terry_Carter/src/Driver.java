/**
* This is the abstract class Driver which defined the structure of the commanders classes.
*
* @version 1.00 15 March 2018
* @author Yining Chen
*/

import java.util.Scanner;

public abstract class Driver {
	
	//InputString is the user input 
	private String InputString;	
	
	//Each commander should have a name
	private String CommanderName;	
	
	//parts is the array of string that spited string pieces
	private String[] parts;
	
	//reader is used to get input from users
	private Scanner Reader;
	
	//it is flag of exception
	private boolean Exception;
	
	//exception message
	private String ExceptionMessage;
		
	//Contractor
	public Driver(String commanderName, Scanner reader) {
		CommanderName = commanderName;
		Reader = reader;
	}
	
	public String getExceptionMessage() {
		return ExceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		ExceptionMessage = exceptionMessage;
	}

	public Scanner getReader() {
		return Reader;
	}

	public void setReader(Scanner reader) {
		Reader = reader;
	}

	public String getInputString() {
		return InputString;
	}

	public void setInputString(String inputString) {
		InputString = inputString;
	}

	public String getCommanderName() {
		return CommanderName;
	}

	public void setCommanderName(String commanderName) {
		CommanderName = commanderName;
	}
	
	public boolean isException() {
		return Exception;
	}

	public void setException(boolean exception) {
		Exception = exception;
	}

	public String[] getParts() {
		return parts;
	}

	public void setParts(String[] parts) {
		this.parts = parts;
	}
}
