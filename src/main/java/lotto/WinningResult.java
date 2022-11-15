package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {

    private final int spendMoney;
    private final int winningMoney;
    private Map<Rank, Integer> rankCount;
    {
        rankCount = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankCount.put(rank, 0);
        }
    }

    public WinningResult(List<Rank> ranks, int lottoPrice) {
        for (Rank rank : ranks) {
            this.rankCount.compute(rank, (k, v) -> v + 1);
        }
        this.spendMoney = ranks.size() * lottoPrice;
        int money = 0;
        for (Rank rank : Rank.values()) {
            money += rank.getWinningMoney() * this.rankCount.get(rank);
        }
        this.winningMoney = money;
    }

    public double getProfit() {
        return this.winningMoney / this.spendMoney * 100;
    }

    public int getSpendMoney() {
        return this.spendMoney;
    }

    public int getWinningMoney() {
        return this.winningMoney;
    }

    public Map<Rank, Integer> getRankCount() {
        return rankCount;
    }

}
