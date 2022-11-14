package lotto;

public enum Winning {
    FAIL(0, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    BONUS(5, 30_000_000),
    SIX(6, 2_000_000_000);

    private final int correctCount;
    private final int rewards;

    Winning(int correctCount, int rewards) {
        this.correctCount = correctCount;
        this.rewards = rewards;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getRewards() {
        return rewards;
    }

    public int getTotalRewards(int count) {
        return this.rewards * count;
    }

    public static Winning valueOf(int correctCount, boolean isBonus) {
        if (correctCount == Winning.FIVE.correctCount) {
            return checkBonus(isBonus);
        }

        for (Winning winning : Winning.values()) {
            if (correctCount == winning.correctCount) {
                return winning;
            }
        }
        return FAIL;
    }

    private static Winning checkBonus(boolean isBonus) {
        if (isBonus) {
            return Winning.BONUS;
        }
        return Winning.FIVE;
    }
}
