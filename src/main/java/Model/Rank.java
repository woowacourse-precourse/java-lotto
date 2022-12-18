package Model;

public enum Rank {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_50_000),
    BONUS(5, 30_000_000),
    SIX(6, 2_000_000_000);

    private final int winningNumbers;
    private final int prize;

    Rank(int winningNumbers, int prize) {
        this.winningNumbers = winningNumbers;
        this.prize = prize;
    }

    public int getWinningNumbers() {
        return winningNumbers;
    }

    public int getPrize() {
        return prize;
    }
}
