package lotto;

import java.util.Arrays;

public enum Ranking {
    NONE(0, 0, false),
    FIFTH(5_000, 3, false),
    FOURTH(50_000, 4, false),
    THIRD(1_500_000, 5, false),
    SECOND(30_000_000, 5, true),
    FIRST(2_000_000_000, 6, false);

    private final int prizeMoney;
    private final int numberCount;
    private final boolean isBonusNumber;

    public static Ranking findOfRanking(int numberCount, boolean isBonusNumber) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> checkNumberCountBonus(ranking, numberCount, isBonusNumber))
                .findAny()
                .orElse(NONE);
    }

    private static boolean checkNumberCountBonus(Ranking ranking, int numberCount, boolean isBonusNumber) {
        if (ranking.getNumberCount() != numberCount) {
            return false;
        }
        if (SECOND.getNumberCount() == numberCount) {
            return ranking.isBonusNumber() == isBonusNumber;
        }
        return true;
    }

    Ranking(int prizeMoney, int numberCount, boolean isBonusNumber) {
        this.prizeMoney = prizeMoney;
        this.numberCount = numberCount;
        this.isBonusNumber = isBonusNumber;
    }

    public int getNumberCount() {
        return numberCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public boolean isBonusNumber() {
        return isBonusNumber;
    }

}
