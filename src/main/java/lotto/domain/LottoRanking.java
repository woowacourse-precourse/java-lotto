package lotto.domain;

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
    private final boolean matchBonusNumber;
    private final int winnings;

    LottoRanking(int matchNumberCount, boolean matchBonusNumber, int winnings) {
        this.matchNumberCount = matchNumberCount;
        this.matchBonusNumber = matchBonusNumber;
        this.winnings = winnings;
    }

    public String stringFormat() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(matchNumberCount)
                .append("개 일치");

        if (matchBonusNumber) {
            stringBuilder
                    .append(", 보너스 볼 일치");
        }

        stringBuilder
                .append(" (")
                .append(winnings)
                .append("원)");

        return stringBuilder.toString();
    }

}
