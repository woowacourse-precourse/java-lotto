package lotto.domain;

import lotto.constant.LottoAward;

import java.util.Map;

public class LottoStatistic {
    private final Map<LottoAward, Integer> groupOfAward;
    private Long sumOfIncome;

    public LottoStatistic(Map<LottoAward, Integer> groupOfAward) {
        this.groupOfAward = groupOfAward;
        calculateSumOfIncome();
    }

    public Double getReturnOnInvestmentRatio(int money) {
        return (double)(sumOfIncome*100) / (double)money;
    }

    public int getWinningCount(LottoAward award) {
        return groupOfAward.getOrDefault(award, 0);
    };

    private void calculateSumOfIncome() {
        if (sumOfIncome != null) return;

        sumOfIncome = 0L;
        for (LottoAward award : LottoAward.values()) {
            sumOfIncome += (long) groupOfAward.getOrDefault(award, 0) * award.getReward();
        }
    }

    public static LottoStatistic of(Map<LottoAward, Integer> groupOfAward) {
        return new LottoStatistic(groupOfAward);
    }
}
