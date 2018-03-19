/**
* This is Relationship class.
*
* @version 1.00 15 March 2018
* @author Tianyu Tan(Terry)
*/
public class Relationship {
	private String FirstPersonName;
	private String SecondPersonName;
	private String Relationship;
	
	public Relationship(String firstPersonName, String secondPersonName, String relationship) {
		FirstPersonName = firstPersonName;
		SecondPersonName = secondPersonName;
		Relationship = relationship;
	}
	
	public Relationship() {}

	public String getFirstPersonName() {
		return FirstPersonName;
	}

	public void setFirstPersonName(String firstPersonName) {
		FirstPersonName = firstPersonName;
	}

	public String getSecondPersonName() {
		return SecondPersonName;
	}

	public void setSecondPersonName(String secondPersonName) {
		SecondPersonName = secondPersonName;
	}

	public String getRelationship() {
		return Relationship;
	}

	public void setRelationship(String relationship) {
		Relationship = relationship;
	}
		
}
