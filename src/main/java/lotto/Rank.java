package lotto;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    LOSE(0, 0);

    private final int countOfMatchingNumbers;
    private final int winningMoney;

    Rank(int countOfMatchingNumbers, int winningMoney) {
        this.countOfMatchingNumbers = countOfMatchingNumbers;
        this.winningMoney = winningMoney;
    }

    public int getWinningMoney() {
        return winningMoney;
    }


}
