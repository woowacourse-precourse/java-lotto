package lotto;

public enum Rank {
    FIRST(6, 2000000000), SECOND(5, 30000000), THIRD(5, 1500000), FOURTH(4, 50000), FIFTH(3, 5000);

    private final int lottoStart;
    private final int prizeMoney;

    private Rank(int lottoStart, int prizeMoney) {
        this.lottoStart = lottoStart;
        this.prizeMoney = prizeMoney;
    }

    public int getlottoStart() {
        return this.lottoStart;

    }

    public int getprizeMoney() {
        return this.prizeMoney;

    }
}
