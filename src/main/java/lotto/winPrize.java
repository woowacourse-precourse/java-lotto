package lotto;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public enum winPrize {
    MISS(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    WIN(6, 2000000000);

    public final int count;
    public final int prize;

    winPrize(int count, int prize) {
        this.count = count;
        this.prize = prize;
    }
}

class winPrizeResult{

    private Map<winPrize, Integer> winPrizeResult;
    public winPrizeResult(){
        winPrizeResult = new EnumMap<winPrize, Integer>(winPrize.class);
        for(winPrize value : winPrize.values()){
            winPrizeResult.put(value, 0);
        }
    }

    public void winPrizeCount(winPrize value){
        winPrizeResult.put(value, winPrizeResult.get(value)+1);
    }

    public int getCount(winPrize value){
        return winPrizeResult.get(value);
    }

    public List<Integer> resultCount() {
        List<Integer> valuelist = new ArrayList<>();
        for (winPrize value : winPrize.values()) {
            valuelist.add(getCount(value));
        }return valuelist;
    }

}