package lotto;

public enum Rank {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000),
    FAIL(0, 0);

    private static final int MIN_MATCH = 3;
    private final int matchCount;
    private final int prize;
    private static final String ERROR_NOT_AVAILABLE = "[ERROR] 유효하지 않은 값입니다.";

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
        throw new IllegalArgumentException(ERROR_NOT_AVAILABLE);
    }
    private boolean matchCount(int matchCount) {
        return this.matchCount == matchCount;
    }
}
