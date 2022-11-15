package lotto.service;

import lotto.domain.Reward;

public class RewardFactory {
    public static Reward createRewardByLottoCount(int lottoCount) {
        if (lottoCount == 6) {
            return Reward.FIFTH_REWARD;
        }
        if (lottoCount == 5) {
            return Reward.THIRD_REWARD;
        }
        if (lottoCount == 4) {
            return Reward.FOURTH_REWARD;
        }
        return Reward.FIFTH_REWARD;
    }

    public static Reward createBonusReward() {
        return Reward.SECOND_REWARD;
    }
}
