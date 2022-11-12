package enumCollections;

public enum RankIndex {
    FIRST(0),
    SECOND(1),
    THIRD(2),
    FOURTH(3),
    FIFTH(4);

    private final int rank;

    PrizeRank(int rank) {
        this.rank = rank;
    }

    public static int getPrizeIndex(String prizeRank) {
        return PrizeRank.valueOf(prizeRank).rank;
    }

    public static int getPrizeIndex(PrizeRank prizeRank) {
        return prizeRank.ordinal();
    }
}
