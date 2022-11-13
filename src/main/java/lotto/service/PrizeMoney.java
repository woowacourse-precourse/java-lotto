package lotto.service;

public enum PrizeMoney {
    FIRST_PLACE_PRIZE(2000000000),
    SECOND_PLACE_PRIZE(30000000),
    THIRD_PLACE_PRIZE(1500000),
    FOURTH_PLACE_PRIZE(50000),
    FIFTH_PLACE_PRIZE(5000);

    private final int prize;

    PrizeMoney(int prizeMoney) {
        this.prize = prizeMoney;
    }

    public int getPrizeMoney() {
        return prize;
    }
}
