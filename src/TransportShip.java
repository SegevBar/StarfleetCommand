package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public class TransportShip extends myAbstractSpaceship{

	private int cargoCapacity;
	private int passengerCapacity;

	public TransportShip(String name, int commissionYear, float maximalSpeed,
						 Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
		super(name, commissionYear, maximalSpeed, crewMembers);
		this.cargoCapacity = cargoCapacity;
		this.passengerCapacity = passengerCapacity;
	}

	public int getCargoCapacity() {
		return this.cargoCapacity;
	}

	public int getPassengerCapacity() {
		return this.passengerCapacity;
	}

	@Override
	public int getAnnualMaintenanceCost() {
		int cargoCost = 5*this.cargoCapacity;
		int passengerCost = 3*this.passengerCapacity;
		return 3000 + cargoCost + passengerCost;
	}

	@Override
	public String toString() {
		return "TransportShip" + System.lineSeparator() + super.toString() + System.lineSeparator() +
				"\tAnnualMaintenanceCost=" + this.getAnnualMaintenanceCost() + System.lineSeparator() +
				"\tCargoCapacity=" + this.cargoCapacity + System.lineSeparator() +
				"\tPassengerCapacity=" + this.passengerCapacity;
	}
}

