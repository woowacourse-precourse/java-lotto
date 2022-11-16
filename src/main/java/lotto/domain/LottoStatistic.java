package lotto.domain;

import lotto.constant.LottoAward;

import java.util.Map;

public class LottoStatistic {
    private final Map<LottoAward, Integer> bunchOfLottoAwards;

    public LottoStatistic(Map<LottoAward, Integer> bunchOfLottoAwards) {
        this.bunchOfLottoAwards = bunchOfLottoAwards;
        calculateSumOfIncome();
    }

    public Double getReturnOnInvestmentRatio(int money) {
        return (double) (calculateSumOfIncome() * 100) / (double) money;
    }

    public int getWinningCount(LottoAward award) {
        return bunchOfLottoAwards.getOrDefault(award, 0);
    }

    private long calculateSumOfIncome() {
        long sumOfIncome = 0L;
        for (LottoAward award : LottoAward.values()) {
            sumOfIncome += (long) bunchOfLottoAwards.getOrDefault(award, 0) * award.getReward();
        }

        return sumOfIncome;
    }

    public static LottoStatistic from(Map<LottoAward, Integer> bunchOfLottoAwards) {
        return new LottoStatistic(bunchOfLottoAwards);
    }
}
