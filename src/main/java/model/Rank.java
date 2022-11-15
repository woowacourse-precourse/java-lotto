package model;

public enum Rank {
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000),
    NONE(0, false, 0);

    private int correctCount;
    private boolean isIncludeBonusNumber;
    private int prize;

    Rank(int correctCount, boolean isIncludeBonusNumber, int prize) {
        this.correctCount = correctCount;
        this.isIncludeBonusNumber = isIncludeBonusNumber;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }
}
