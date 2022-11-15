package lotto.score;

public enum Grade {

    FIFTH(3, 0, 5000),
    FOURTH(4, 0, 50000),
    THIRD(5, 0, 150000),
    SECOND(5, 1, 30000000),
    FIRST(6, 0, 2000000000);

    private final int correctCount;
    private final int bonusCount;
    private final int reward;

    Grade(int correctCount, int bonusCount, int reward) {
        this.correctCount = correctCount;
        this.bonusCount = bonusCount;
        this.reward = reward;
    }

    public int getCorrectCount() {
        return this.correctCount;
    }

    public int getBonusCount() {
        return this.bonusCount;
    }

    public int getReward() {
        return this.reward;
    }
}
