package domain;

public enum LottoRanking {
    FIRST(6, false),
    SECOND(5, true),
    THIRD(5, false),
    FOURTH(4, false),
    FIFTH(3, false);

    private final int correct;
    private final boolean bonusScore;

    LottoRanking(int correct, boolean bonusScore) {
        this.correct = correct;
        this.bonusScore = bonusScore;
    }

    public int getCorrect() {
        return correct;
    }

    public boolean isBonusScore() {
        return bonusScore;
    }
}
