package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends myAbstractBattleship {

	private int numberOfTechnicians;

	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		this.numberOfTechnicians = numberOfTechnicians;
	}

	@Override
	public int getAnnualMaintenanceCost() {
		int weaponsMaintenanceCost = super.getAnnualWeaponsMaintenanceCost();
		double discount = (0.1*this.numberOfTechnicians*weaponsMaintenanceCost);
		int weaponsDiscount = (int) (weaponsMaintenanceCost - discount);
		return 5000 + weaponsDiscount;
	}

	public int getNumberOfTechnicians() {
		return this.numberOfTechnicians;
	}

	@Override
	public String toString() {
		return "Bomber" + System.lineSeparator() + super.toString() + System.lineSeparator() +
				"\tAnnualMaintenanceCost=" + this.getAnnualMaintenanceCost() + System.lineSeparator() +
				"\tWeaponArray=" + this.weapons.toString() + System.lineSeparator() +
				"\tNumberOfTechnicians=" + this.numberOfTechnicians;
	}
}
