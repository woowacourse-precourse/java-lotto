package lotto.domain;

public enum WinningPrize {
    FIFTH_PRIZE(5, 5000),
    FOURTH_PRIZE(4, 50000),
    THIRD_PRIZE(3, 1500000),
    SECOND_PRIZE(2, 30000000),
    FIRST_PRIZE(1, 2000000000),
    NONE_PRIZE(0, 0);

    private static final WinningPrize[] WINNING_PRIZES = WinningPrize.values();
    private final int rank;
    private final double distribution;

    WinningPrize(int rank, double distribution) {
        this.rank = rank;
        this.distribution = distribution;
    }

    public int getRank() {
        return rank;
    }

    public double getDistribution() {
        return distribution;
    }

    public static WinningPrize of(int index) {
        return WINNING_PRIZES[index];
    }

    public static int calculateRank(int matchScore) {
        if (matchScore < LottoNumberRule.MINIMUM_NUMBER_MATCH.getValue()) {
            return 0;
        }
        return WINNING_PRIZES[matchScore - LottoNumberRule.MINIMUM_NUMBER_MATCH.getValue()]
            .getRank();
    }
    public double getRevenue(int rankCount) {
        return getDistribution() * rankCount;
    }
}
