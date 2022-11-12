package lotto.domain;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Rank {
    FIRST(6, 2_000_000_000,0),
    SECOND(5, 30_000_000,0),
    THIRD(5, 1_500_000,0),
    FOURTH(4, 50_000,0),
    FIFTH(3, 5_000,0),
    NONE(0, 0,0);

    private final int matchCount;
    private final int prize;
    protected int count;

    Rank(int matchCount, int prize, int count) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.count = count;
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

    public int getCount() {
        return count;
    }
}
