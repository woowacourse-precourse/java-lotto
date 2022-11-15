package lotto.service;

import static lotto.utils.Constants.FIRST_PLACE;
import static lotto.utils.Constants.LAST_PLACE;

import lotto.domain.Ranking;

public class RewardService {

    public static long calcuateReward(int[] rankingCount) {
        long totalReward = 0;

        for (int ranking = FIRST_PLACE; ranking <= LAST_PLACE; ranking++) {
            int reward = Ranking.values()[ranking].getReward();
            totalReward += (long) reward * rankingCount[ranking];
        }

        return totalReward;
    }

    public static double calculateRateOfReturn(int purchaseAmount, long reward) {
        double rateOfReturn = ((double)reward / purchaseAmount) * 100 - 100;
        return Math.round((rateOfReturn * 10) / 10.0);
    }
}
