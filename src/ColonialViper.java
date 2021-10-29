package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper extends Fighter{

	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers,
						 List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}

	@Override
	public int getAnnualMaintenanceCost() {
		int weaponsMaintenanceCost = super.getAnnualWeaponsMaintenanceCost();
		int crewMaintenance = 500*crewMembers.size();
		int enginesMaintenanceCost = (int)(500*this.maximalSpeed);

		return 4000 + weaponsMaintenanceCost + crewMaintenance + enginesMaintenanceCost;
	}

	@Override
	public String toString() {
		return super.toString("ColonialViper");
	}
}
