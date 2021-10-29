package il.ac.tau.cs.sw1.ex9.starfleet;


import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class StealthCruiser extends Fighter {

	protected static List<Weapon> LaserCannons = Arrays.asList(new Weapon("Laser Cannons",10,100));
	protected static int numOfStealthCruiser = 0;

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		numOfStealthCruiser++;
	}

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers){
		this(name, commissionYear, maximalSpeed, crewMembers, LaserCannons);
	}

	@Override
	public int getAnnualMaintenanceCost() {
		int fighterMaintenanceCost = super.getAnnualMaintenanceCost();
		int engineMaintenanceCost = numOfStealthCruiser*50;
		return fighterMaintenanceCost + engineMaintenanceCost;
	}


	@Override
	public String toString() {
		return super.toString("StealthCruiser");
	}
}
