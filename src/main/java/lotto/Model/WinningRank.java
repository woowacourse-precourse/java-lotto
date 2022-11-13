package lotto.Model;

import java.util.Arrays;

public enum WinningRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    SIXTH(0, 0)
    ;

    private static final int MIN_MATCH_COUNT = 3;
    public static final String ERROR = "[ERROR] ";
    public static final String NOT_COUNT_STATE = "유효한 개수가 아닙니다.";

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

    private boolean Count(int matchCount) {
        return this.matchCount == matchCount;
    }
    public static WinningRank valueOf(int matchCount, boolean matchBonus){
        if (matchCount < MIN_MATCH_COUNT){
            return SIXTH;
        }
        if (SECOND.Count(matchCount) && matchBonus){
            return SECOND;
        }
        return Arrays.stream(WinningRank.values())
                .filter(rank -> rank.Count(matchCount) && rank != SECOND)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR + NOT_COUNT_STATE));
    }

}
