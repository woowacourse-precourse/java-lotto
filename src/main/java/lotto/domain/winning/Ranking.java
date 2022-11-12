package lotto.domain.winning;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Ranking {

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

    private static final Map<Integer, Ranking> RANKING_UNRELATED_TO_BONUS_NUMBER =
            Arrays.stream(Ranking.values())
                    .filter(lottoRanking -> !lottoRanking.isMatchedBonusNumber)
                    .collect(Collectors.toUnmodifiableMap(
                            lottoRanking -> lottoRanking.countOfMatchingNumber,
                            lottoRanking -> lottoRanking)
                    );

    private final int countOfMatchingNumber;
    private final boolean isMatchedBonusNumber;
    private final long winnings;

    Ranking(int countOfMatchingNumber, boolean isMatchedBonusNumber, long winnings) {
        this.countOfMatchingNumber = countOfMatchingNumber;
        this.isMatchedBonusNumber = isMatchedBonusNumber;
        this.winnings = winnings;
    }

    public static Ranking ranking(int countsOfMatchingNumber, boolean isMatchedBonusNumber) {
        if (isSecond(countsOfMatchingNumber, isMatchedBonusNumber)) {
            return SECOND;
        }

        return RANKING_UNRELATED_TO_BONUS_NUMBER.get(countsOfMatchingNumber);
    }

    private static boolean isSecond(int countsOfMatchingNumber, boolean isMatchedBonusNumber) {
        final int MATCH_NUMBER_FOR_SECOND_OR_THIRD = 5;
        return countsOfMatchingNumber == MATCH_NUMBER_FOR_SECOND_OR_THIRD
                && isMatchedBonusNumber;
    }

    public long sumOfWinnings(int count) {
        return winnings * count;
    }

    public int countOfMatchingNumber() {
        return countOfMatchingNumber;
    }

    public boolean isMatchedBonusNumber() {
        return isMatchedBonusNumber;
    }

    public long winnings() {
        return winnings;
    }
}
