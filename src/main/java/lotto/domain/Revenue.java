package lotto.domain;

import java.util.Map;

public class Revenue {
    Map<String, Integer> lottoStatus;

    public Revenue(Map<String, Integer> lottoStatus) {
        this.lottoStatus = lottoStatus;
    }

    public float calculateRevenue(int money) {
        int sum = 0;
        for (Rank rank : Rank.values()) {
            int value = lottoStatus.get(rank.name());
            int lottoMoney = rank.getLottoMoney();
            sum += value * lottoMoney;
        }
        return sum / (float)money * 100;
    }
}
