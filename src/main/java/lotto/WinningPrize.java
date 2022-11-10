package lotto;

public enum WinningPrize {
    FIRST(2_000_000_000, 6),
    SECOND(30_000_000,5),
    THIRD(1_500_000,5),
    FOURTH(50_000,4),
    FIFTH(5_000,3);

    private int winningMoney;
    private int howManyNumbersIncluded;

    WinningPrize(int winningMoney, int howManyNumbersIncluded) {
    }
}
