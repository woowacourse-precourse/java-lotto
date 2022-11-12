package lotto;

import java.util.Arrays;

public enum MatchingType {
    THREE_MATCH(3),
    FOUR_MATCH(4),
    FIVE_MATCH(5),
    FIVE_WITH_BONUS_MATCH(5),
    SIX_MATCH(6),
    NOT_MATCH(0);

    private final int matchCount;

    MatchingType(int matchCount) {
        this.matchCount = matchCount;
    }
    public int getMatchCount() {
        return matchCount;
    }

    public boolean isFiveMatch() {
        return this.matchCount == FIVE_MATCH.getMatchCount();
    }

    public static MatchingType findByCorrectCount(int correctCount) {
        return Arrays.stream(MatchingType.values())
                .filter(matchingType ->
                        correctCount == matchingType.getMatchCount())
                .findAny()
                .orElse(NOT_MATCH);
    }

    public boolean isWinningType() {
        return THREE_MATCH.matchCount <= this.matchCount && this.matchCount <= SIX_MATCH.matchCount;
    }

}