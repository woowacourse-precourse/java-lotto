package lotto;

public enum Prize {
    FIRST(2_000_000_000), SECOND(30_000_000), THIRD(1_500_000), FOURTH(50_000), FIFTH(5_000), NOTHING(0);

    private final int REWARD;

    Prize(int reward) {
        REWARD = reward;
    }

    int reward() {
        return REWARD;
    }
}
