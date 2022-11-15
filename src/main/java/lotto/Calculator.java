package lotto;

import java.util.HashMap;
import java.util.List;

public class Calculator {
    private CalcWinningStat calcWinningStat;
    private CalcYield calcYield;
    private HashMap<Integer, Integer> rankCount = new HashMap<>();
    private double yield;

    public Calculator(List<Integer> winningNum, int bonusNum, List<Lotto> lotto) {
        calcWinningStat = new CalcWinningStat(winningNum, bonusNum, lotto);
        this.rankCount = calcWinningStat.getRankCount();

        calcYield = new CalcYield(rankCount, lotto.size());
        this.yield = calcYield.getYield();
    }

    public int getCountByRank(int rank) {
        if (rankCount.containsKey(rank)) {
            return rankCount.get(rank);
        }
        else {
            return 0;
        }
    }

    public double getYield() {
        return yield;
    }
}

