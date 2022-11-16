package lotto.domain;

public enum Prize {

    FIFTH_PRIZE(5000),
    FOURTH_PRIZE(50000),
    THIRD_PRIZE(1500000),
    FIRST_PRIZE(2000000000);

    private final int prize;

    Prize(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }
}
