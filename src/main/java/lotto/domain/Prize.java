package lotto.domain;

public enum Prize {
    FIFTH(5_000),
    FOURTH(50_000),
    THIRD(1_500_000),
    SECOND(30_000_000),
    FIRST(2_000_000_000);

    private final int prizeMoney;

    Prize(int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
