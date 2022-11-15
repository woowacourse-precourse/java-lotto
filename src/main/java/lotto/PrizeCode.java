package lotto;

public enum PrizeCode {
    FIRST(0, 2000000000),
    SECOND(1, 30000000),
    THIRD(2, 1500000),
    FOURTH(3, 50000),
    FIFTH(4, 5000);

    private final int code;
    private final int prizeMoney;

    PrizeCode(int code, int prizeMoney) {
        this.code = code;
        this.prizeMoney = prizeMoney;
    }

    public int getCode() {
        return code;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
