package lotto.domain;

import lotto.constant.LottoAward;

import java.util.Map;

public class LottoStatistic {
    private final Map<LottoAward, Integer> bunchOfLottoAwards;
    private Long sumOfIncome;

    public LottoStatistic(Map<LottoAward, Integer> bunchOfLottoAwards) {
        this.bunchOfLottoAwards = bunchOfLottoAwards;
        calculateSumOfIncome();
    }

    public Double getReturnOnInvestmentRatio(int money) {
        return (double) (sumOfIncome * 100) / (double) money;
    }

    public int getWinningCount(LottoAward award) {
        return bunchOfLottoAwards.getOrDefault(award, 0);
    }

    private void calculateSumOfIncome() {
        if (sumOfIncome != null) return;

        sumOfIncome = 0L;
        for (LottoAward award : LottoAward.values()) {
            sumOfIncome += (long) bunchOfLottoAwards.getOrDefault(award, 0) * award.getReward();
        }
    }

    public static LottoStatistic from(Map<LottoAward, Integer> bunchOfLottoAwards) {
        return new LottoStatistic(bunchOfLottoAwards);
    }
}
