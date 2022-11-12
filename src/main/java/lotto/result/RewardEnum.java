package lotto.result;

public enum RewardEnum {
    WIN_6(2_000_000_000),
    WIN_5_BONUS(30_000_000),
    WIN_5(1_500_000),
    WIN_4(50_000),
    WIN_3(5_000),
    NONE(0);

    private final int reward;

    RewardEnum(int reward) {
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }

    public static RewardEnum getFromResult(int matches, boolean bonus) {
        if (matches == 6) {
            return WIN_6;
        }
        if (matches == 5 && bonus) {
            return WIN_5_BONUS;
        }
        if (matches == 5) {
            return WIN_5;
        }
        if (matches == 4) {
            return WIN_4;
        }
        if (matches == 3) {
            return WIN_3;
        }
        return NONE;
    }
}
