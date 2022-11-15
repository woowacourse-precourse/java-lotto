package lotto;

import java.util.HashMap;

public class CalcYield {
    private HashMap<Integer, Integer> rankCount;
    private int numOfLotto;
    private double yield;
    public CalcYield(HashMap<Integer, Integer> rankCount, int numOfLotto){
        this.rankCount = rankCount;
        this.numOfLotto = numOfLotto;
        calculate();
    }

    private void calculate() {
        double profit = 0;
        for(Rank rank: Rank.values()) {
            if (rankCount.containsKey(rank.getPlace())) {
                profit += rankCount.get(rank.getPlace()) * rank.getPrize();
            }
        }
        yield = (profit/(1000*numOfLotto))*100;
    }

    public double getYield() {
        return yield;
    }
}
