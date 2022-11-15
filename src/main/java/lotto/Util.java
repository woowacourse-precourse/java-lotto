package lotto;

import java.util.HashMap;
import java.util.Map;

public class Util {
    public static HashMap<Integer,Integer> setPrizeBuckets(){
        HashMap<Integer,Integer> prizeBuckets = new HashMap<>();
        prizeBuckets.put(3,0);
        prizeBuckets.put(4,0);
        prizeBuckets.put(5,0);
        prizeBuckets.put(-1,0);
        prizeBuckets.put(6,0);
        return prizeBuckets;
    }
    public static HashMap<Integer,Integer> setPrizeInfo(){
        HashMap<Integer,Integer> prizeInfo = new HashMap<>();
        prizeInfo.put(3,5000);
        prizeInfo.put(4,50000);
        prizeInfo.put(5,150000);
        prizeInfo.put(-1,30000000);
        prizeInfo.put(6,2000000000);
        return prizeInfo;
    }
}
