package lotto;

import java.util.*;

public enum Ranking {
    FIRST(2_000_000_000, 6, false),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5, false),
    FOURTH(50_000, 4, false),
    FIFTH(5_000, 3, false),
    NOTRANKING(0, 0, false)
    ;

    private int prize;
    private int count;
    private boolean hasBonusNumber;

    Ranking(int prize, int count, boolean hasBonusNumber) {
        this.prize = prize;
        this.count = count;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static Ranking rankingOfLabel(int count, boolean hasBonusNumber) {
        return Arrays.stream(values())
                .filter(value -> value.count == count && value.hasBonusNumber == hasBonusNumber)
                .findAny()
                .orElse(NOTRANKING);
    }

    public int getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }
}
