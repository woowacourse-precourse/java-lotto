package model;

import java.util.EnumMap;
import java.util.List;

public class User {
    private final List<Lotto> lotteries;
    private EnumMap<Prize, Integer> winningHistory;

    public List<Lotto> lotteries(){ return lotteries; }

    public Integer getHistoryOf(Prize prize){
        return winningHistory.get(prize);
    }

    public void setWinningHistory(Prize prize, Integer times){
        winningHistory.put(prize, times);
    }


    public User(List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }
}
