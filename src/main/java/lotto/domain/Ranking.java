package lotto.domain;

public enum Ranking {
    rank1(6,false,2_000_000_000),
    rank2(5,true,30_000_000),
    rank3(5,false,1_500_000),
    rank4(4,false,50_000),
    rank5(3,false,5_000),
    None(-1,false,0);

    private final int matchingCount;
    private final boolean isBonusMatching;
    private final int prizeMoney;

    Ranking(int matchingCount, boolean isBonusMatching ,int prizeMoney){
        this.matchingCount = matchingCount;
        this.isBonusMatching = isBonusMatching;
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Ranking findRanking(int matchingCount, boolean isBonusMatching){
        for (Ranking value : values()) {
            if (matchingCount == value.matchingCount && isBonusMatching == value.isBonusMatching){
                return value;
            }
        }
        return None;
    }
}
