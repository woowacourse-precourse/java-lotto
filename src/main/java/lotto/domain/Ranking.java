package lotto.domain;

import java.util.Arrays;

public enum Ranking {
    FIRST(2000000000, 6, false, "2,000,000,000"),
    SECOND(30000000, 5, true, "30,000,000"),
    THIRD(1500000, 5, false, "1,500,000"),
    FOURTH(50000, 4, false, "50,000"),
    FIFTH(5000, 3, false, "5,000"),
    DEFAULT(0, 0, false, "0");

    private final int prize;
    private final int count;
    private final boolean hasBonusNumber;
    private final String prizeMoneyFormat;

    Ranking(int prize, int count, boolean hasBonusNumber, String prizeMoneyFormat) {
        this.prize = prize;
        this.count = count;
        this.hasBonusNumber = hasBonusNumber;
        this.prizeMoneyFormat = prizeMoneyFormat;
    }

    public static Ranking findRanking(int cnt, boolean hasBonusNumber) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.count == cnt && ranking.hasBonusNumber == hasBonusNumber)
                .findAny()
                .orElse(DEFAULT);
    }

    public long multiple(Integer count) {
        return (long) prize * count;
    }

    public int getCount() {
        return count;
    }

    public int getPrize() {
        return prize;
    }

    public boolean getHasBonusBall() {
        return hasBonusNumber;
    }

    public String getPrizeMoneyFormat() {
        return prizeMoneyFormat;
    }
}