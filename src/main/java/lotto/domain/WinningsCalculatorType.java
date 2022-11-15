package lotto.domain;

import java.util.Arrays;
import java.util.function.Function;

public enum WinningsCalculatorType {
    FIRST_PLACE(6, 0),
    SECOND_PLACE(5, 1),
    THIRD_PLACE(5, 0),
    FOURTH_PLACE(4, 0),
    FIFTH_PLACE(3, 0),
    NO_RANK(0, 0);

    private int matchingCountOfWinning;
    private int matchingCountOfBonus;

    WinningsCalculatorType(int matchingCountOfWinning, int matchingCountOfBonus) {
        this.matchingCountOfWinning = matchingCountOfWinning;
        this.matchingCountOfBonus = matchingCountOfBonus;
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
}
