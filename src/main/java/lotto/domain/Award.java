package lotto.domain;

public enum Award {
    ZERO(0),
    ONE(0),
    TWO(0),
    THREE(5_000),
    FOUR(50_000),
    FIVE(1_500_000),
    SIX(2_000_000_000),

    FIVE_BONUS(30_000_000);

    private final int reward;

    Award(int reward) {
        this.reward = reward;
    }

    public long getReward() {
        return this.reward;
    }

    public static Award getByOrdinal(int ordinal) {
        return Award.values()[ordinal];
    }
}
