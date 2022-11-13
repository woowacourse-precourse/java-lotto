package lotto.model;

import java.util.stream.Stream;

public enum WinDetail {
    First(6,2_000_000_000),
    Second(5,30_000_000),
    Third(5,1_500_000),
    Fourth(4,50_000),
    Fifth(3,5_000),
    NONE(-1,0);

    private int matchCount;
    private int reward;

    WinDetail(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static WinDetail findRankBy(int matchCount) {
        return Stream.of(values())
                .filter(winDetail -> (winDetail.matchCount == matchCount))
                .findFirst()
                .orElse(NONE);
    }

}
