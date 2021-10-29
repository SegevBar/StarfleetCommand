package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Objects;
import java.util.Set;

public abstract class myAbstractSpaceship implements Spaceship {

    protected String name;
    protected int commissionYear;
    protected float maximalSpeed;
    protected int firePower;
    protected Set<? extends CrewMember> crewMembers;

    public myAbstractSpaceship(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers) {
        this.name = name;
        this.commissionYear = commissionYear;
        this.maximalSpeed = maximalSpeed;
        this.crewMembers = crewMembers;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCommissionYear() {
        return this.commissionYear;
    }

    @Override
    public float getMaximalSpeed() {
        return this.maximalSpeed;
    }

    @Override
    public int getFirePower() {
        return 10;
    }

    @Override
    public Set<? extends CrewMember> getCrewMembers(){ //extends any class that implements crewMember
        return this.crewMembers;
    }

    @Override
    public String toString() {
        return "\tName=" + this.getName() + System.lineSeparator() +
                "\tCommissionYear=" + this.commissionYear + System.lineSeparator() +
                "\tMaximalSpeed=" + this.maximalSpeed + System.lineSeparator() +
                "\tFirePower=" + this.getFirePower() + System.lineSeparator() +
                "\tCrewMembers=" + this.crewMembers.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        myAbstractSpaceship that = (myAbstractSpaceship) o;
        return commissionYear == that.commissionYear && Float.compare(that.maximalSpeed, maximalSpeed) == 0 && firePower == that.firePower && Objects.equals(name, that.name) && Objects.equals(crewMembers, that.crewMembers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, commissionYear, maximalSpeed, firePower, crewMembers);
    }
}
