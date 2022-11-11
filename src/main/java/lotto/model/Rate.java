package lotto.model;

import lotto.enums.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Rate {
    private Map<Rank,Integer> winningStats;
    private Map<Rank,Integer> rankPrice;
    private double earningRate;

    public Rate(Map<Rank,Integer> winningStats){
        this.winningStats = winningStats;
        setRankPrice();
        setEarningRate(winningStats);

    }

    public void getEarningRate() {

    }

    private void setRankPrice(){
        Map<Rank,Integer> rankPrice = new HashMap<>();
        rankPrice.put(Rank.first,2000000000);
        rankPrice.put(Rank.second,30000000);
        rankPrice.put(Rank.third,1500000);
        rankPrice.put(Rank.fourth,50000);
        rankPrice.put(Rank.fifth,5000);
    }

    private void setEarningRate(Map<Rank,Integer> winningStats) {

    }

    private int calcEarning(Map<Rank,Integer> winningStats) {
        int earningPrice = 0;

        for (Map.Entry<Rank, Integer> elem : winningStats.entrySet()) {
            earningPrice += rankPrice.get(elem.getKey()) * elem.getValue();
        }
        return earningPrice;
    }

    private int calcSpending(Map<Rank,Integer> winningStats) {
        return 0;
    }
}
