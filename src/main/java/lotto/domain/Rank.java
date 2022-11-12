package lotto.domain;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }


    public static Rank valueOfRank(int matchCount, boolean isContainBonusNumber) {
        if (matchCount == 5 && isContainBonusNumber) {
            return Rank.SECOND;
        }
        if (matchCount == 5){
            return Rank.THIRD;
        }
        if (matchCount < 3){
            return Rank.NONE;
        }
        return Arrays.stream(Rank.values())
                .filter(resultT -> resultT.matchCount == matchCount)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
