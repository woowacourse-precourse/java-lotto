package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LottoResult {

    private Map<LottoRank, Integer> lottoResult = new LinkedHashMap<>();

    public LottoResult() {
        initResult();
    }

    private void initResult() {
        for (LottoRank lottoRank : LottoRank.values()) {
            lottoResult.put(lottoRank, 0);
        }
    }

    public void add(LottoRank lottoRank) {
        lottoResult.put(lottoRank, lottoResult.get(lottoRank) + 1);
    }

    public double getRateOfProfit(int purchaseLottoMoney) {
        return calculateRateOfProfit(getTotalProfit(), purchaseLottoMoney);
    }

    public int getTotalProfit() {
        int profit = 0;
        for (LottoRank lottoRank : lottoResult.keySet()) {
            profit += lottoRank.calculateProfit(lottoResult.get(lottoRank));
        }
        return profit;
    }

    private double calculateRateOfProfit(int profit, int purchaseLottoMoney) {
        return ((double) profit / purchaseLottoMoney) * 100;
    }

    public Map<LottoRank, Integer> get() {
        return lottoResult;
    }

}
