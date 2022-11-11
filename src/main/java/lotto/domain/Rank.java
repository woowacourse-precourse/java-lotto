package lotto.domain;

public enum Rank {
    FIRST("2,000,000,000원", 6),
    SECOND("30,000,000원", 7),
    THIRD("1,500,000원", 5),
    FOURTH("50,000원", 4),
    FIFTH("5,000원", 3);

    private final String prize;
    private final int matchingCount;
    Rank(String prize, int matchingCount) {
        this.prize = prize;
        this.matchingCount = matchingCount;
    }

    public int getMatchingCount() {
        return matchingCount;
    }
}
