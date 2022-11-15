package lotto.model;

import java.util.stream.Stream;

public enum WinDetail {
    First(6,BonusType.No_Matter,2_000_000_000),
    Second(5,BonusType.Should_Matching,30_000_000),
    Third(5,BonusType.Should_Not_Matching,1_500_000),
    Fourth(4,BonusType.No_Matter,50_000),
    Fifth(3,BonusType.No_Matter,5_000),
    NONE(-1,BonusType.No_Matter,0);

    private final int matchCount;
    private final BonusType bonusType;
    private final long reward;

    WinDetail(int matchCount, BonusType bonusType, long reward) {
        this.matchCount = matchCount;
        this.bonusType = bonusType;
        this.reward = reward;
    }

    public static WinDetail findRankBy(int matchCount, boolean isBonusMatching) {
        return Stream.of(values())
                .filter(winDetail -> (winDetail.matchCount == matchCount)
                &&(winDetail.bonusType.filter(isBonusMatching)))
                .findFirst()
                .orElse(NONE);
    }

    public long reward(){
        return reward;
    }
}
