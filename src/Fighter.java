package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Fighter extends myAbstractBattleship{


	public Fighter(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}

	@Override
	public int getAnnualMaintenanceCost() {
		int weaponsMaintenanceCost = super.getAnnualWeaponsMaintenanceCost();
		int enginesMaintenanceCost = (int)(1000*this.maximalSpeed);

		return 2500 + weaponsMaintenanceCost + enginesMaintenanceCost;
	}

	@Override
	public String toString() {
		return toString("Fighter");
	}

	public String toString(String son) {
		return son + System.lineSeparator() + super.toString() + System.lineSeparator() +
				"\tAnnualMaintenanceCost=" + this.getAnnualMaintenanceCost() + System.lineSeparator() +
				"\tWeaponArray=" + this.weapons.toString();
	}
}
