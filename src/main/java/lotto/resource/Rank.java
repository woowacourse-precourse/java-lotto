package lotto.resource;

public enum Rank {
    FIRST("1등", 2000000000, 6),
    SECOND("2등", 30000000, 5),
    THIRD("3등", 1500000, 5),
    FOURTH("4등", 50000, 4),
    FIFTH("5등", 5000, 3);

    private final String tier;
    private final int prizeMoney;
    private final int matchingCount;

    Rank(String tier, int prizeMoney, int matchingCount) {
        this.tier = tier;
        this.prizeMoney = prizeMoney;
        this.matchingCount = matchingCount;
    }

    public String getTier() {
        return tier;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchingCount() {
        return matchingCount;
    }
}
