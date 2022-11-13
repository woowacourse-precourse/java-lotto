package lotto;

public enum WinningReward {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000);

    private final int price;

    WinningReward(final int price) {
        this.price = price;
    }

    public int getPriceByRank(int rank) {
        if (rank == 1) return FIRST.price;
        if (rank == 2) return SECOND.price;
        if (rank == 3) return THIRD.price;
        if (rank == 4) return FOURTH.price;
        if (rank == 5) return FIFTH.price;
        return 0;
    }
}
