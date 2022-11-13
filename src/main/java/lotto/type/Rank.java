package lotto.type;

public enum Rank {
    FIRST(6, 0, 2000000000),
    SECOND(5, 1, 30000000),
    THIRD(5, 0, 1500000),
    FOUR(4, 0, 50000),
    FIVE(3, 0, 5000),
    NONE(0, 0, 0);

    private final int correctCount;
    private final int correctBonusCount;
    private final int reward;

    Rank(int correctCount, int correctBonusCount, int reward) {
        this.correctCount = correctCount;
        this.correctBonusCount = correctBonusCount;
        this.reward = reward;
    }

    public static Rank getRank(int correctCount, int correctBonusCount) {
        if (correctCount == 5 && correctBonusCount == 1) {
            return Rank.SECOND;
        }

        for (int i = 0; i < values().length; i++) {
            if (values()[i].correctCount == correctCount) {
                return values()[i];
            }
        }
        return Rank.NONE;
    }

    public int getReward() {
        return reward;
    }
}
