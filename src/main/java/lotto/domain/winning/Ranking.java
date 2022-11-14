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
                    .filter(lottoRanking -> !lottoRanking.isMatchedBonus)
                    .collect(Collectors.toUnmodifiableMap(
                            lottoRanking -> lottoRanking.matchCounts,
                            lottoRanking -> lottoRanking));

    private final int matchCounts;
    private final boolean isMatchedBonus;
    private final long winnings;

    Ranking(int matchCounts, boolean isMatchedBonus, long winnings) {
        this.matchCounts = matchCounts;
        this.isMatchedBonus = isMatchedBonus;
        this.winnings = winnings;
    }

    static Ranking ranking(int matchCounts, boolean isMatchedBonus) {
        if (isSecond(matchCounts, isMatchedBonus)) {
            return SECOND;
        }

        return RANKING_UNRELATED_TO_BONUS_NUMBER.get(matchCounts);
    }

    private static boolean isSecond(int matchCounts, boolean isMatchedBonus) {
        final int MATCH_COUNTS_FOR_SECOND_OR_THIRD = 5;
        return matchCounts == MATCH_COUNTS_FOR_SECOND_OR_THIRD && isMatchedBonus;
    }

    long sumOfWinnings(int count) {
        return winnings * count;
    }

    public int matchCounts() {
        return matchCounts;
    }

    public boolean isMatchedBonus() {
        return isMatchedBonus;
    }

    public long winnings() {
        return winnings;
    }
}
