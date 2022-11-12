package lotto.domain;

public enum WinningResult {
    FIFTH(3, 5000, "5등"),
    FOURTH(4, 50000, "4등"),
    THIRD(5, 1500000, "3등"),
    SECOND(5, 30000000, "2등(보너스 볼 일치)"),
    FIRST(6, 2000000000, "1등");

    private final int matchNum;
    private final int prizeMoney;
    private final String rank;

    WinningResult(int matchNum, int prizeMoney, String rank) {
        this.matchNum = matchNum;
        this.prizeMoney = prizeMoney;
        this.rank = rank;
    }

    public int getMatchNum() {
        return matchNum;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getRank() {
        return rank;
    }
}
