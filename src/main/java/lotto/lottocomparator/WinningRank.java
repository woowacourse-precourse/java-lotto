package lotto.lottocomparator;

/**
 * 로또 당첨에서 1등부터 5등까지를 나타냅니다.
 */
public enum WinningRank {
    /**
     * 1등
     */
    FIRST(2000000000),
    /**
     * 2등
     */
    SECOND(30000000),
    /**
     * 3등
     */
    THIRD(1500000),
    /**
     * 4등
     */
    FOURTH(50000),
    /**
     * 5등
     */
    FIFTH(5000),
    /**
     * 꽝
     */
    LOSING_TICKET(0);
    private final int reward;

    WinningRank(int reward) {
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }
}
