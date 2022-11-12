package lotto.domain;

public enum Rank {
    FIRST(2000000000, 6, "6개 일치"),
    SECOND(30000000, 7, "5개 일치, 보너스 볼 일치"),
    THIRD(1500000, 5, "5개 일치"),
    FOURTH(50000, 4, "4개 일치"),
    FIFTH(5000, 3, "3개 일치");

    private final int prize;
    private final int matchingCount;
    private final String result;
    Rank(int prize, int matchingCount, String result) {
        this.prize = prize;
        this.matchingCount = matchingCount;
        this.result = result;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrize() {
        return prize;
    }

    public String getResult() {
        return result;
    }
}
