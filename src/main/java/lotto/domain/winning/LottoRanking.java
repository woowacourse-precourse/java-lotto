package lotto.domain.winning;

import java.text.NumberFormat;

public enum LottoRanking {

    FIFTH(
            3,
            false,
            5_000
    ),
    FORTH(
            4,
            false,
            50_000
    ),
    THIRD(
            5,
            false,
            1_500_000
    ),
    SECOND(
            5,
            true,
            30_000_000
    ),
    FIRST(
            6,
            false,
            2_000_000_000
    ),
    ;

    private final int matchNumberCount;
    private final boolean isMatchedBonusNumber;
    private final int winnings;

    LottoRanking(int matchNumberCount, boolean isMatchedBonusNumber, int winnings) {
        this.matchNumberCount = matchNumberCount;
        this.isMatchedBonusNumber = isMatchedBonusNumber;
        this.winnings = winnings;
    }

    public int sumOfWinnings(int count) {
        return winnings * count;
    }

    public boolean isMatchedOnlyNumberCount(int count) {
        return matchNumberCount == count && !isMatchedBonusNumber;
    }

    public String stringFormat() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(matchNumberCount).append("개 일치");

        if (isMatchedBonusNumber) {
            stringBuilder.append(", 보너스 볼 일치");
        }

        stringBuilder
                .append(" (")
                .append(NumberFormat.getNumberInstance().format(winnings))
                .append("원)");

        return stringBuilder.toString();
    }
}
