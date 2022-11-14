package lotto;

public enum Rank {
    FIRST(6, 2_000_000_000), // 1등
    SECOND(5, 30_000_000), // 2등
    THIRD(5, 1_500_000), // 3등
    FOURTH(4, 50_000), // 4등
    FIFTH(3, 5_000), // 5등
    MISS(0, 0);

    private static final int WINNING_MIN_MATCH = 3;

    private int matchingCount;
    private int winningMoney;

    private Rank(int matchingCount, int winningMoney) {
        this.matchingCount = matchingCount;
        this.winningMoney = winningMoney;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int matchingCount, boolean matchBonus) {
        if (matchingCount < WINNING_MIN_MATCH) {
            return MISS;
        }

        if (SECOND.match(matchingCount) && matchBonus) {
            return SECOND;
        }

        for (Rank rank : values()) {
            if (rank.match(matchingCount)) {
                return rank;
            }
        }

        throw new IllegalArgumentException("[ERROR]" +matchingCount + "는 유효하지 않은 값입니다.");
    }

    private boolean match(int matchingCount) {
        return this.matchingCount == matchingCount;
    }
}
