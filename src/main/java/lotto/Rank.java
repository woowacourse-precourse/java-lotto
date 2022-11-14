package lotto;

public enum Rank {
    FIRST_PRIZE(2_000_000_000L),
    THIRD_PRIZE(1_500_000L),
    FOURTH_PRIZE(50_000L),
    FIFTH_PRIZE(5_000L),
    NOTHING(0L),
    SECOND_PRIZE(30_000_000L);

    private final long amount;

    Rank(long amount) {
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }
}
