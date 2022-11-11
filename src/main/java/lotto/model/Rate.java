package lotto.model;

import lotto.enums.Rank;

import java.util.Map;

public class Rate {
    private Map<Rank,Integer> winningStats;
    private double earningRate;

    public Rate(Map<Rank,Integer> winningStats){
        this.winningStats = winningStats;
        setEarningRate(winningStats);
        
    }

    public void getEarningRate() {

    }

    private void setEarningRate(Map<Rank,Integer> winningStats) {

    }

    private int calcEarning(Map<Rank,Integer> winningStats) {
        return 0;
    }

    private int calcSpending(Map<Rank,Integer> winningStats) {
        return 0;
    }
}
