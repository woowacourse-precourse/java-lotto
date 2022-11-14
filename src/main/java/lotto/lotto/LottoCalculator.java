package lotto.lotto;

import java.util.Map;
import lotto.rank.Rank;

public class LottoCalculator {
    private long amount;
    private long profit;

    public LottoCalculator(int amount) {
        this.amount = amount;
    }


    public double getRate() {
        return (double) profit / amount * 100;
    }

    public void calPrizeProfit(Map<Rank, Integer> prize) {
        for (Rank rank : Rank.values()) {
            profit += rank.getWinProfit() * prize.get(rank);
        }
    }

    public long getProfit() {
        return profit;
    }

}
