package lotto;

import java.util.List;

public enum Prize {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000);

    private int reward;

    Prize(int reward) {
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }
}
