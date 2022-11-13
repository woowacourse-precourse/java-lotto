package lotto.Model;

public enum WinningRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    SIXTH(0, 0)
    ;

    private static final int MIN_MATCH_COUNT = 3;
    private static final String INVALID_VALUE = "는 유효하지 않은 값입니다.";
    private final int matchCount;
    private final int WinningAmount;
    WinningRank(int matchCount, int WinningAmount) {
        this.matchCount = matchCount;
        this.WinningAmount = WinningAmount;
    }

    public int matchCount(){
        return matchCount;
    }

    public int WinningAmount(){
        return WinningAmount;
    }
}
