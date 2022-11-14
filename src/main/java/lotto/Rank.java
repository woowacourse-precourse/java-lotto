package lotto;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    FAIL(0, 0);

    private static final int MIN_MATCH = 3;
    private final int matchCount;
    private final int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    int getPrize() {
        return prize;
    }

    int getMatchCount() {
        return matchCount;
    }

    public static Rank value(int matchCount, boolean matchBonus) {
        if (matchCount < MIN_MATCH) {
            return FAIL;
        }
        if (matchCount == SECOND.getMatchCount() && matchBonus) {
            return SECOND;
        }
        if (matchCount == THIRD.getMatchCount() && !matchBonus) {
            return THIRD;
        }
        for (Rank rank : values()) {
            if (rank.matchCount(matchCount)) {
                return rank;
            }
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 값입니다.");
    }
    private boolean matchCount(int matchCount) {
        return this.matchCount == matchCount;
    }
}
