package lotto.domain;

import java.util.Map;
import java.util.Map.Entry;

public class CalculateProfitRate {
    private int principal;
    private double profits;
    private double profitRate;
    private Map<String, Integer> totalPrize;
    /**
     * 수익률 = 수익 / 원금
     * 처음 입력받은 원금과 수익이 필요함
     * 수익 = 당첨된 상금의 합
     * 수익률은 소수점 둘째 자리에서 반올림
     */
    public CalculateProfitRate(int principal, Map<String, Integer> totalPrize) {
        this.principal = principal;
        this.totalPrize = totalPrize;
    }

    public void getPrizeMoney(Map<String, Integer> totalPrize) {
        for (Entry<String, Integer> entry : totalPrize.entrySet()) {
            int prizeMoney = PrizeRank.valueOf(entry.getKey()).getPrizeMoney();
            profits += prizeMoney * entry.getValue();
        }
    }

    public void getProfitRate() {
        profitRate = Math.round((profits / principal) * 10) / 10;
    }

}
