package lotto.lotto;

import java.util.Map;
import lotto.rank.Rank;

public class LottoCalculator {
    private long amount;
    private long profit;

    private static final Buy buy = new Buy();

    public LottoCalculator(int amount) {
        this.amount = amount;
    }


    public double getRate() { // 수익률
        return (double) profit / amount * 100;
    }

    public void calPrizeProfit(Map<Rank, Integer> prize) { // 수익 계산
        for (Rank rank : Rank.values()) {
            profit += rank.getWinProfit() * prize.get(rank);
        }
    }

    public long getProfit() {
        return profit;
    }

}
