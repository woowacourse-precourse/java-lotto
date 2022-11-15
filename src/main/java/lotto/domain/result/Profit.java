package lotto.domain.result;

import java.util.Map;

public class Profit {
    private static final int PERCENTAGE = 100;
    private static final int ZERO = 0;

    public static double calculateProfit(Map<LottoRank, Integer> lottoResult, long purchaseAmount) {
        long income = calculateIncome(lottoResult);

        double profit = (double)income / purchaseAmount * PERCENTAGE;

        return profit;
    }

    public static long calculateIncome(Map<LottoRank, Integer> lottoResult) {
        long income = ZERO;

        for (LottoRank lottoRank : lottoResult.keySet()) {
            long money = lottoRank.getPrizeMoney() * lottoResult.get(lottoRank);

            income += money;
        }

        return income;
    }
}
