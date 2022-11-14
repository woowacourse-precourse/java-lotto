package lotto.lottocomparator;

/**
 * 로또 당첨에서 1등부터 5등까지를 나타냅니다.
 */
public enum WinningRank {
    /**
     * 1등
     */
    FIRST(0, 2000000000),
    /**
     * 2등
     */
    SECOND(1, 30000000),
    /**
     * 3등
     */
    THIRD(2, 1500000),
    /**
     * 4등
     */
    FOURTH(3, 50000),
    /**
     * 5등
     */
    FIFTH(4, 5000),
    /**
     * 꽝
     */
    LOSING_TICKET(5, 0);
    private final int rank;
    private final int reward;

    WinningRank(int rank, int reward) {
        this.rank = rank;
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }

    public int getRank() {
        return rank;
    }
}
