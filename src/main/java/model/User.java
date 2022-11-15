package model;

import java.util.EnumMap;
import java.util.List;

public class User {
    private final List<Lotto> lotteries;
    private EnumMap<Prize, Integer> winningHistory;

    public List<Lotto> lotteries(){ return lotteries; }


    public void setWinningHistory(Prize prize, Integer times){
        winningHistory.put(prize, times);
    }

    public EnumMap<Prize, Integer> getWinningHistory() {
        return winningHistory;
    }

    public List<Lotto> getLotteries(){
        return lotteries;
    }

    public Integer getTimesOf(Prize prize){
        return winningHistory.get(prize);
    }


    public User(List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }
}
