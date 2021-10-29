package il.ac.tau.cs.sw1.ex9.starfleet;


import java.util.*;


public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and finally in ascending order by
	 * name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear (Collection<Spaceship> fleet) {
		List<Spaceship> fleetList = new ArrayList<>(fleet);
		List<String> descriptionList = new ArrayList<>();
		Collections.sort(fleetList, new mySpaceshipComparator());

		for(Spaceship ship : fleetList) {
			descriptionList.add(ship.toString());
		}
		return descriptionList;
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		Map<String, Integer> numOfInstances = new HashMap<>();

		for(Spaceship ship : fleet) {
			String typeName = ship.getClass().getSimpleName();
			if(numOfInstances.containsKey(typeName)) {
				numOfInstances.put(typeName, numOfInstances.get(typeName)+1);
			}else {
				numOfInstances.put(typeName, 1);
			}
		}
		return numOfInstances;
	}


	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) {
		int totalCost = 0;
		for(Spaceship ship : fleet) {
			totalCost += ship.getAnnualMaintenanceCost();
		}
		return totalCost;
	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		Set<String> setOfWeapons = new HashSet<>();
		for(Spaceship ship : fleet) {
			if(ship instanceof myAbstractBattleship) {
				myAbstractBattleship battleShip = (myAbstractBattleship)ship;
				for(Weapon w : battleShip.getWeapon()) {
					setOfWeapons.add(w.getName());
				}
			}
		}
		return setOfWeapons;
	}

	/*
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		int numOfCrewMembers = 0;
		for(Spaceship ship : fleet) {
			numOfCrewMembers += ship.getCrewMembers().size();
		}
		return numOfCrewMembers;
	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's ships. 
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		int numOfOfficers = 0;
		float sumOfAges = 0;

		for(Spaceship ship : fleet) {
			for(CrewMember member : ship.getCrewMembers()) {
				if(member instanceof Officer) {
					numOfOfficers++;
					sumOfAges += member.getAge();
				}
			}
		}
		return sumOfAges/numOfOfficers;
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		Map<Officer, Spaceship> highestRanksMap = new HashMap<>();

		for(Spaceship ship : fleet) {
			Officer highestRankOfficer = null;
			OfficerRank highestRank = OfficerRank.Ensign;
			for(CrewMember member : ship.getCrewMembers()) {
				if(member instanceof Officer) {
					Officer cMember = (Officer)member;
					if(cMember.getRank().ordinal() > highestRank.ordinal()) {
						highestRank = cMember.getRank();
						highestRankOfficer = cMember;
					}
				}
			}
			if(highestRankOfficer != null) {
				highestRanksMap.put(highestRankOfficer, ship);
			}
		}

		return highestRanksMap;
	}

	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		Map<OfficerRank, Integer> mapOfRanks = new HashMap<>();

		for(Spaceship ship : fleet) {
			for(CrewMember member : ship.getCrewMembers()) { //filling mapOfRanks
				if(member instanceof Officer) {
					Officer cMember = (Officer)member;
					OfficerRank rank = cMember.getRank();

					if(mapOfRanks.containsKey(rank)){
						mapOfRanks.put(rank, mapOfRanks.get(rank) + 1);
					}else {
						mapOfRanks.put(rank, 1);
					}
				}
			}
		}

		List<Map.Entry<OfficerRank, Integer>> ranksSorted = new ArrayList<>(mapOfRanks.entrySet());
		Collections.sort(ranksSorted, new myRanksComparator());
		return ranksSorted;
	}


}
