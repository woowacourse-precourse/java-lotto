package lotto.domain;

import lotto.utils.ExceptionType;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    ZERO(0, 0);

    private final int countOfMatch;
    private final int money;

    Rank(int countOfMatch, int money) {
        this.countOfMatch = countOfMatch;
        this.money = money;
    }

    public static Rank matchRank(int countOfMatch, boolean bonusMatching) {
        if (countOfMatch < FIFTH.countOfMatch) {
            return ZERO;
        }

        if (isSECOND(countOfMatch, bonusMatching)) {
            return SECOND;
        }

        for (Rank rank : values()) {
            if(isMatchAboutRank(rank, countOfMatch)) {
                return rank;
            }
        }

        throw new IllegalArgumentException(ExceptionType.IS_NOT_CORRECT_VALUE.getMessage());
    }

    private static boolean isSECOND(int countOfMatch, boolean bonusMatching) {
        if (countOfMatch == SECOND.countOfMatch && bonusMatching) {
            return true;
        }
        return false;
    }

    private static boolean isMatchAboutRank(Rank rank, int countOfMatch) {
        if(rank.countOfMatch == countOfMatch) {
            return true;
        }
        return false;
    }
}
