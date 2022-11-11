package lotto.domain;

import lotto.config.InputConfig;

import java.util.List;
import java.util.Map;

public class User {
    private final List<Lotto> purchasedLotto;
    private Statistics statistics;

    public User(List<Lotto> lotto) {
        this.purchasedLotto = lotto;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public float calculateProfit() {
        long purchaseMoney = purchasedLotto.size() * InputConfig.LOTTO_PRICE;
        long totalProfit = statistics.getTotalProfit();

        float profitPercent = (float)totalProfit / (float) purchaseMoney * 100;
        return profitPercent;
    }

    public Map<Rank, Integer> getResult() {
        return statistics.getResult(purchasedLotto);
    }

}
