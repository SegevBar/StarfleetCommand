package il.ac.tau.cs.sw1.ex9.starfleet;

public class CrewWoman extends myAbstractCrewMember {

	
	public CrewWoman(int age, int yearsInService, String name){

		super(age,yearsInService,name);
	}

	@Override
	public String toString() {
		return toString("CrewWoman");
	}

	public String toString(String name) {
		return name + System.lineSeparator() + super.toString();
	}

}
