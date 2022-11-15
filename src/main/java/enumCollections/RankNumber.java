package enumCollections;

public enum RankNumber {
    FIRST(6),
    SECOND(7), // 2등은 별도의 조건문으로 처리하므로 당첨 조건에 해당하지 않는 숫자 7 사용
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

    public static RankNumber getRank(int sameNumbers) {
        for (RankNumber rank : RankNumber.values()) {
            if (rank.getRankNumber(rank) == sameNumbers) {
                return rank;
            }
        }
        return null;
    }
}
