package lotto.domain;

public enum Award {
    ONE(0),
    TWO(0),
    THREE(5_000),
    FOUR(50_000),
    FIVE(1_500_000),
    FIVE_BONUS(30_000_000),
    SIX(2_000_000_000);

    private final int price;

    Award(int price) {
        this.price = price;
    }

    public long getReward() {
        return this.price;
    }

    public static Award getByOrdinal(int ord) {
        return Award.values()[ord-1];
    }
}
