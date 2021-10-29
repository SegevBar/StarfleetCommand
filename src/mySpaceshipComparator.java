package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Comparator;

public class mySpaceshipComparator implements Comparator<Spaceship> {

    @Override
    public int compare(Spaceship o1, Spaceship o2) {
        if(o1.getFirePower() > o2.getFirePower()) { //compare fire power (descending)
            return -1;
        }else if(o1.getFirePower() < o2.getFirePower()) {
            return 1;
        }else if(o1.getCommissionYear() > o2.getCommissionYear()) { //fire power is equal, compare commission year (descending)
            return -1;
        }else if(o1.getCommissionYear() < o2.getCommissionYear()) {
            return 1;
        }
        return o1.getName().compareTo(o2.getName()); //fire power and commission year are equal, compare name (lexi, ascending)

    }

}

