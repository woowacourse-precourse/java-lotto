package lotto;

import java.util.Arrays;
import java.util.function.Function;

public enum MatchingType {
    THREE_MATCH(3, correctCount -> correctCount * 5_000L),
    FOUR_MATCH(4, correctCount -> correctCount * 50_000L),
    FIVE_MATCH(5, correctCount -> correctCount * 1_500_000L),
    FIVE_WITH_BONUS_MATCH(5, correctCount -> correctCount * 30_000_000L),
    SIX_MATCH(6, correctCount -> correctCount * 2_000_000_000L),
    NOT_MATCH(0, correctCount -> correctCount);

    private final int matchCount;

    private final Function<Long, Long> expression;

    MatchingType(int matchCount, Function<Long, Long> expression) {
        this.matchCount = matchCount;
        this.expression = expression;
    }

    public static MatchingType findByCorrectCount(int correctCount) {
        return Arrays.stream(MatchingType.values())
                .filter(matchingType ->
                        correctCount == matchingType.getMatchCount())
                .findAny()
                .orElse(NOT_MATCH);
    }

    public long calculatePrize(long correctCount) {
        return expression.apply(correctCount);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isFiveMatch() {
        return this.matchCount == FIVE_MATCH.getMatchCount();
    }

    public boolean isWinningType() {
        return THREE_MATCH.matchCount <= this.matchCount && this.matchCount <= SIX_MATCH.matchCount;
    }

}