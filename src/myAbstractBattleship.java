package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public abstract class myAbstractBattleship extends myAbstractSpaceship {

    protected List<Weapon> weapons;

    public myAbstractBattleship(String name, int commissionYear, float maximalSpeed,
                                Set<? extends CrewMember> crewMembers, List<Weapon> weapons) {

        super(name, commissionYear, maximalSpeed, crewMembers);
        this.weapons = weapons;
    }

    public List<Weapon> getWeapon(){
        return this.weapons;
    }

    @Override
    public int getFirePower() {
        int firePower = super.getFirePower();
        for(Weapon weapon: this.weapons) {
            firePower += weapon.getFirePower();
        }
        return firePower;
    }

    public int getAnnualWeaponsMaintenanceCost() {
        int weaponsMaintenanceCost = 0;
        for(Weapon weapon : this.weapons) {
            weaponsMaintenanceCost += weapon.getAnnualMaintenanceCost();
        }
        return weaponsMaintenanceCost;
    }
}
