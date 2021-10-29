package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Comparator;
import java.util.Map;

public class myRanksComparator implements Comparator<Map.Entry<OfficerRank,Integer>> {

    @Override
    public int compare(Map.Entry<OfficerRank, Integer> o1, Map.Entry<OfficerRank, Integer> o2) {
        if(o1.getValue() > o2.getValue()) {
            return 1;
        }else if (o1.getValue() < o2.getValue()) {
            return -1;

        }else if(o1.getKey().ordinal() > o2.getKey().ordinal()) { //has the same num of instances
            return 1;
        }else {
            return -1;
        }
    }

}
