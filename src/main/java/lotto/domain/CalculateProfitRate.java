package lotto.domain;

import java.util.Map;
import java.util.Map.Entry;

public class CalculateProfitRate {
    private final int principal;
    private double profits;

    public CalculateProfitRate(int principal, Map<String, Integer> totalPrize) {
        this.principal = principal;
        getPrizeMoney(totalPrize);
    }

    private void getPrizeMoney(Map<String, Integer> totalPrize) {
        for (Entry<String, Integer> entry : totalPrize.entrySet()) {
            int prizeMoney = PrizeRank.valueOf(entry.getKey()).getPrizeMoney();
            profits += prizeMoney * entry.getValue();
        }
    }

    public double getProfitRate() {
        return Math.round(((profits * 100) / principal) * 10) / 10.0;
    }
}
