package lotto.domain;

import java.util.Arrays;
import java.util.function.Function;

public enum WinningsCalculatorType {
    FIRST_PLACE(6, 0, count -> count * 2000000000),
    SECOND_PLACE(5, 1, count -> count * 30000000),
    THIRD_PLACE(5, 0, count -> count * 1500000),
    FOURTH_PLACE(4, 0, count -> count * 50000),
    FIFTH_PLACE(3, 0, count -> count * 5000),
    NO_RANK(0, 0, count -> count);

    private int matchingCountOfWinning;
    private int matchingCountOfBonus;
    private Function<Long, Long> expression;

    WinningsCalculatorType(
            int matchingCountOfWinning,
            int matchingCountOfBonus,
            Function<Long, Long> expression
    ) {
        this.matchingCountOfWinning = matchingCountOfWinning;
        this.matchingCountOfBonus = matchingCountOfBonus;
        this.expression = expression;
    }

    public static WinningsCalculatorType selectRankingType(
            int matchingCountOfWinning,
            int matchingCountOfBonus
    ) {
        return Arrays.stream(WinningsCalculatorType.values())
                .filter(ranking -> isMatchedRanking(ranking, matchingCountOfWinning, matchingCountOfBonus))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 당첨 개수입니다."));
    }

    private static boolean isMatchedRanking(
            WinningsCalculatorType ranking,
            int matchingCountOfWinning,
            int matchingCountOfBonus
    ) {
        return ranking.matchingCountOfWinning <= matchingCountOfWinning
                &&
                ranking.matchingCountOfBonus <= matchingCountOfBonus;
    }

    public long calculateWinnings(long count) {
        return expression.apply(count);
    }
}
