package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST_PRIZE(6, false, 2_000_000_000, "2,000,000,000"),
    SECOND_PRIZE(5, true, 30_000_000, "30,000,000"),
    THIRD_PRIZE(5, false, 1_500_000 , "1,500,000"),
    FOURTH_PRIZE(4, false, 50_000, "50,000"),
    FIFTH_PRIZE(3, false, 5_000, "5,000"),
    MISS(0, false, 0, "0")
    ;

    private final int matchCounts;
    private final boolean isBonusBall;
    private final int prizeMoney;
    private final String prizeMoneyFormat;

    private Rank(int matchCounts, boolean isBonusBall, int prizeMoney, String prizeMoneyFormat) {
        this.matchCounts = matchCounts;
        this.isBonusBall = isBonusBall;
        this.prizeMoney = prizeMoney;
        this.prizeMoneyFormat = prizeMoneyFormat;
    }

    public static Rank of(int matchCounts, boolean isBonusBall) {
        if (isSecondPrize(matchCounts, isBonusBall)) {
            return SECOND_PRIZE;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.SECOND_PRIZE)
                .filter(rank -> rank.matches(matchCounts))
                .findFirst()
                .orElseGet(() -> MISS);
    }

    private boolean matches(int matchCounts) {
        return this.matchCounts == matchCounts;
    }

    private static boolean isSecondPrize(int matchCounts, boolean isBonusBall) {
        return isBonusBall == SECOND_PRIZE.isBonusBall && matchCounts == SECOND_PRIZE.matchCounts;
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }

    public int getMatchCounts() {
        return this.matchCounts;
    }

    public String getPrizeMoneyFormat() {
        return prizeMoneyFormat;
    }
}
