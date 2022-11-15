package lotto.domain;

public enum Winning {
    FIFTH(3, 5000, "3개 일치"),
    FOURTH(4, 50000, "4개 일치"),
    THIRD(5, 1500000, "5개 일치"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, 2000000000, "6개 일치");

    private final int matchNum;
    private final int prizeMoney;
    private final String matchMessage;

    Winning(int matchNum, int prizeMoney, String matchMessage) {
        this.matchNum = matchNum;
        this.prizeMoney = prizeMoney;
        this.matchMessage = matchMessage;
    }

    public int getMatchNum() {
        return matchNum;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getMatchMessage() {
        return matchMessage;
    }
}
