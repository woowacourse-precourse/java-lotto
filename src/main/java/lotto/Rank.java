package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Rank {
    rank0(0,0,0),
    rank1(1,0,0),
    rank2(2,0,0),
    rank3(3,5000,3),
    rank4(4,50000,4),
    rank5(5,1500000,5),
    rank7(7,30000000,5),
    rank6(6,2000000000,6);


    private int count;
    private int prize;
    private int place;
    Rank(int count, int prize,int place) {
        this.count=count;
        this.prize=prize;
        this.place=place;
    }

    public int getCount() {
        return count;
    }

    public Map<String, Integer> getPrizeAndPlace() {
        Map<String,Integer> set = new HashMap<>();
        set.put("prize",prize);
        set.put("place",place);
        return set;
    }

    public int getPlace() {
        return place;
    }
    public int getPrize() {
        return prize;
    }
}
