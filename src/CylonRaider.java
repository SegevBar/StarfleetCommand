package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider extends Fighter{

	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers,
					   List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}

	@Override
	public int getAnnualMaintenanceCost() {
		int weaponsMaintenanceCost = super.getAnnualWeaponsMaintenanceCost();
		int crewMaintenance = 500*crewMembers.size();
		int enginesMaintenanceCost = (int)(1200*this.maximalSpeed);

		return 3500 + weaponsMaintenanceCost + crewMaintenance + enginesMaintenanceCost;
	}

	@Override
	public String toString() {
		return super.toString("CylonRaider");
	}
}

