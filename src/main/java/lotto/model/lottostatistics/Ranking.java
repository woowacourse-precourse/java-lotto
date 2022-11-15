package lotto.model.lottostatistics;

public enum Ranking {

    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false),
    DEFAULT(0, 0, false);

    private final int rank;
    private final long prize;
    private final boolean bonusFlag;

    Ranking(int rank, long prize, boolean bonusFlag) {
        this.rank = rank;
        this.prize = prize;
        this.bonusFlag = bonusFlag;
    }

    public static Ranking findRanking(final int matchCount, final boolean isBonus) {
        for (Ranking rank : Ranking.values()) {
            if (rank.rank == matchCount && rank.bonusFlag == isBonus) {
                return rank;
            }
        }

        return DEFAULT;
    }

    public int getRank() {
        return this.rank;
    }

    public long getPrize() {
        return this.prize;
    }

}
