package lotto.domain;

import java.text.DecimalFormat;
import java.util.Arrays;

public enum Ranking {

    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false),
    NOTHING(0, 0, false);

    private static final String HAS_BONUS_NUMBER_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원)";
    private static final String NO_BONUS_NUMBER_MESSAGE = "%d개 일치 (%s원)";
    public static final int SECOND_RIGHT_COUNT = 5;

    public int getPrize() {
        return prize;
    }

    private final int rightCount;
    private final int prize;
    private final boolean hasBonusNumber;

    Ranking(int rightCount, int prize, boolean hasBonusNumber) {
        this.rightCount = rightCount;
        this.prize = prize;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static Ranking findRankingByRightCountAndHasBonusNumber(int rightCount, boolean hasBonusNumber) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.rightCount == rightCount)
                .findFirst()
                .map(ranking -> getRanking(ranking, hasBonusNumber))
                .orElse(NOTHING);
    }

    private static Ranking getRanking(Ranking ranking, boolean hasBonusNumber) {
        if (ranking.rightCount == SECOND_RIGHT_COUNT && hasBonusNumber) {
            return SECOND;
        }
        return ranking;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        if (hasBonusNumber) {
            return String.format(HAS_BONUS_NUMBER_MESSAGE, rightCount, decimalFormat.format(prize));
        }
        return String.format(NO_BONUS_NUMBER_MESSAGE, rightCount, decimalFormat.format(prize));
    }
}
