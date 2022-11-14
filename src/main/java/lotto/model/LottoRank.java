package lotto.model;

import static lotto.model.Lotto.*;

public enum LottoRank {

    LOSE(LOTTO_LOSE_REWARD),
    FIFTH(LOTTO_FIFTH_REWARD),
    FOURTH(LOTTO_FOURTH_REWARD),
    THIRD(LOTTO_THIRD_REWARD),
    SECOND(LOTTO_SECOND_REWARD),
    FIRST(LOTTO_FIRST_REWARD);

    private final int reward;

    LottoRank(int reward) {

        this.reward = reward;
    }


    public int getReward() {

        return reward;
    }
}
