package lotto.model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private final List<Lotto> lotteries;
    private final Integer purchase;
    private Map<Double, Integer> winningHistory;

    public List<Lotto> lotteries(){ return lotteries; }

    public void setWinningHistory(Prize prize, Integer times){
        winningHistory.put(prize.HIT(), times);
    }

    public Map<Double, Integer> getWinningHistory() {
        return winningHistory;
    }

    public List<Lotto> getLotteries(){
        return lotteries;
    }

    public Integer getTimesOf(Prize prize){
        return winningHistory.get(prize.HIT());
    }

    public List<Integer> getAllOfTimes(){
        List<Integer> times = new ArrayList<Integer>();

        for(Prize prize: Prize.values()){
            times.add(winningHistory.get(prize.HIT()));
        }

        return times;
    }


    public Integer purchase(){
        return this.purchase;
    }


    public User(List<Lotto> lotteries) {
        winningHistory = new HashMap<>();

        this.lotteries = lotteries;
        this.purchase = lotteries.size() * 1000;

        for(Prize prize : Prize.values()){
            winningHistory.put(prize.HIT(), 0);
        }
    }
}
