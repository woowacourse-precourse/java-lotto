package lotto;

public enum Prize {
    FIRST(2_000_000_000, 6), SECOND(30_000_000, 5), THIRD(1_500_000, 5), FOURTH(50_000, 4), FIFTH(5_000, 3), NOTHING(0, 0);

    private final long REWARD;
    private final int CORRECT;

    Prize(int reward, int correct) {
        REWARD = reward;
        CORRECT = correct;
    }

    public long reward() {
        return REWARD;
    }

    public int correct() {
        return CORRECT;
    }
}
