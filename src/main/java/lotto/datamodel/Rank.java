package lotto.datamodel;

public enum Rank {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000),
    NONE(0);

    private final int amount;

    Rank (int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
