package enumCollections;

public enum RankNumber {
    FIRST(6),
    THIRD(5),
    FOURTH(4),
    FIFTH(3);

    private final int number;

    RankNumber(int number) {
        this.number = number;
    }

    public static int getRankNumber(RankNumber rank) {
        return rank.number;
    }
}
