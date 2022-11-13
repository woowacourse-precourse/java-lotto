package lotto.domain;

import java.util.Arrays;

public enum Rank {
    BANG(0, false, 0L),
    FIFTH(3, false, 5_000L),
    FOURTH(4, false, 50_000L),
    THIRD(5, false, 1_500_000L),
    SECOND(5, true, 30_000_000L),
    FIRST(6, false, 2_000_000_000L);


    private final int sameNumbersCount;
    private final boolean hasBonusNumber;
    private final long prize;

    Rank(int sameNumbersCount, boolean hasBonusNumber, long prize) {
        this.sameNumbersCount = sameNumbersCount;
        this.hasBonusNumber = hasBonusNumber;
        this.prize = prize;
    }

    public static Rank findRank(int sameNumbersCount, boolean hasBonusNumber) {
        return Arrays.stream(values())
                .filter(rank -> rank.check(sameNumbersCount, hasBonusNumber))
                .findAny()
                .orElse(BANG);
    }

    public int getSameNumbersCount() {
        return sameNumbersCount;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }

    public long getPrize() {
        return prize;
    }

    private boolean check(int sameNumbersCount, boolean hasBonusNumber) {
        if (needBonusNumber(sameNumbersCount)) {
            return equalsSameNumbersCount(sameNumbersCount) && equalsBonusNumber(hasBonusNumber);
        }
        return equalsSameNumbersCount(sameNumbersCount);
    }

    private boolean needBonusNumber(int sameNumbersCount) {
        return sameNumbersCount == 5;
    }

    private boolean equalsSameNumbersCount(int sameNumbersCount) {
        return this.sameNumbersCount == sameNumbersCount;
    }

    private boolean equalsBonusNumber(boolean hasBonusNumber) {
        return this.hasBonusNumber == hasBonusNumber;
    }
}
