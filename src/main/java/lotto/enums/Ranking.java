package lotto.enums;

public enum Ranking {
    FIRST_RANK(1,6, false),
    SECOND_RANK(2,5, true),
    THIRD_RANK(3,5, false),
    FOURTH_RANK(4,4, false),
    FIFTH_RANK(5,3, false);

    private final int rank;
    private final int numberMatchCount;
    private final boolean bonusNumberMatchCount;

    Ranking(int rank, int numberMatchCount, boolean bonusNumberMatchCount) {
        this.rank = rank;
        this.numberMatchCount = numberMatchCount;
        this.bonusNumberMatchCount = bonusNumberMatchCount;
    }

    public int getRank() {
        return rank;
    }

    public int getNumberMatchCount() {
        return numberMatchCount;
    }

    public boolean getBonusNumberMatchCount() {
        return bonusNumberMatchCount;
    }
}
