package enumCollections;

public enum RankIndex {
    FIRST(0),
    SECOND(1),
    THIRD(2),
    FOURTH(3),
    FIFTH(4);

    private final int index;

    RankIndex(int index) {
        this.index = index;
    }

    public static int getRankIndex(String rank) {
        return RankIndex.valueOf(rank).index;
    }

    public static int getPrizeIndex(RankIndex prizeRank) {
        return prizeRank.ordinal();
    }
}
