package lotto.model;

public enum WinningPrize {
    FIVE_THOUSAND(5000),
    FIFTY_THOUSAND(50000),
    FIFTEEN(1500000),
    THIRTY(30000000),
    TWO_HUNDRED(2000000000);

    private final int prize;

    WinningPrize(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return this.prize;
    }
}
