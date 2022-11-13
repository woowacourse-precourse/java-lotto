package lotto;

public enum Rank {

    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FORTH(4, 50000, false),
    FIFTH(3, 5000, false);

    private int correctCount;
    private int prize;
    private boolean correctBonus;


    Rank(int correctCount, int prize, boolean correctBonus) {
        this.correctCount = correctCount;
        this.prize = prize;
        this.correctBonus = correctBonus;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getPrize() {
        return prize;
    }
}
