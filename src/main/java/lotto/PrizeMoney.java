package lotto;

public enum PrizeMoney {
    ONE(2000000000),
    TWO(30000000),
    THREE(1500000),
    FOUR(50000),
    FIVE(5000);

    private final Integer prizeMoney;

    PrizeMoney(Integer prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public Integer getPrizeMoney() {
        return prizeMoney;
    }
}
