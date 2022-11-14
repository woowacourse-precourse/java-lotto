package lotto.domain;

public enum Ranking {
    first(1, 6, 2_000_000_000),
    second(2, 5, 30_000_000),
    third(3, 5, 1_500_000),
    fourth(4, 4, 50_000),
    fifth(5, 3, 5_000);

    private final int value;
    private final int matchingCount;
    private final int prizeMoney;

    Ranking(int value, int numberOfMatching, int prizeMoney) {
        this.value = value;
        this.matchingCount = numberOfMatching;
        this.prizeMoney = prizeMoney;
    }

    public int value() {
        return value;
    }

    public int matchingCount() {
        return matchingCount;
    }

    public int prizeMoney() {
        return prizeMoney;
    }
}
