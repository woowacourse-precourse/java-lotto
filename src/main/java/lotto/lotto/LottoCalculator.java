package lotto.lotto;

import java.util.Map;
import lotto.rank.Rank;

public class LottoCalculator {
    private long amount;
    private long totalWinPrize;

    public LottoCalculator(int amount) {
        this.amount = amount;
    }


    public double getRate() {
        return (double) totalWinPrize / amount * 100;
    }

    public void calPrizeProfit(Map<Rank, Integer> winStats) {
        for (Rank rank : Rank.values()) {
            totalWinPrize += rank.getLottoPrize() * winStats.get(rank);
        }
    }

    public long getTotalWinPrize() {
        return totalWinPrize;
    }

}
