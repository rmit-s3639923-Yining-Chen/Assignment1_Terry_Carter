import java.util.Scanner;

public abstract class Drive {
	
	private String InputString;	
	private String CommanderName;	
	private String[] parts;
	private Scanner Reader;
	private boolean Exception;
		
	public Drive(String commanderName, Scanner reader) {
		CommanderName = commanderName;
		Reader = reader;
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
