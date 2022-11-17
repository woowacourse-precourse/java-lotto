package lotto.domain.enums;

public enum Rank {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private int correctCount;
    private int winningMoney;

    Rank(int correctCount, int winningMoney) {
        this.correctCount = correctCount;
        this.winningMoney = winningMoney;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
