package lotto.model;

public enum Winning {
    THREE(5_000),
    FOUR(50_000),
    FIVE(1_500_000),
    FIVE_BONUS(30_000_000),
    SIX(2_000_000_000);

    private final long winningPrice;

    Winning(long winningPrice) {
        this.winningPrice = winningPrice;
    }

    public long getWinningPrice() {
        return winningPrice;
    }
}
