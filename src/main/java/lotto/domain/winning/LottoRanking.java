package lotto.domain.winning;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

enum LottoRanking {

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

    private static final Map<Integer, LottoRanking> LOTTO_RANKING_UNRELATED_TO_BONUS_NUMBER =
            Arrays.stream(LottoRanking.values())
                    .filter(lottoRanking -> !lottoRanking.isMatchedBonusNumber)
                    .collect(Collectors.toUnmodifiableMap(
                            lottoRanking -> lottoRanking.matchNumberCount,
                            lottoRanking -> lottoRanking)
                    );

    private final int matchNumberCount;
    private final boolean isMatchedBonusNumber;
    private final int winnings;

    public static LottoRanking lottoRanking(int count) {
        return LOTTO_RANKING_UNRELATED_TO_BONUS_NUMBER.get(count);
    }

    LottoRanking(int matchNumberCount, boolean isMatchedBonusNumber, int winnings) {
        this.matchNumberCount = matchNumberCount;
        this.isMatchedBonusNumber = isMatchedBonusNumber;
        this.winnings = winnings;
    }

    public int sumOfWinnings(int count) {
        return winnings * count;
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
