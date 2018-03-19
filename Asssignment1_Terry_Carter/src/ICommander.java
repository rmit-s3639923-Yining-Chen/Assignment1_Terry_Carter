/**
* This is the interface of commander
*
* @version 1.00 15 March 2018
* @author Tianyu Tan(Terry)
*/
import java.util.ArrayList;

public interface ICommander {
	public void Input(ArrayList<Person> ps, ArrayList<Relationship> rs);
	public void Execute(ArrayList<Person> ps, ArrayList<Relationship> rs);
	public void DisplayResult(ArrayList<Person> ps, ArrayList<Relationship> rs);
}
