package lotto;

import java.util.Arrays;

public enum WinningType {
    THREE_MATCH(3),
    FOUR_MATCH(4),
    FIVE_MATCH(5),
    FIVE_WITH_BONUS_MATCH(5),
    SIX_MATCH(6),
    NOT_MATCH(0);

    private final int matchCount;

    WinningType(int matchCount) {
        this.matchCount = matchCount;
    }
    public int getMatchCount() {
        return matchCount;
    }

    public boolean isFiveMatch() {
        return this.matchCount == FIVE_MATCH.getMatchCount();
    }

    public static WinningType findByCorrectCount(int correctCount) {
        return Arrays.stream(WinningType.values())
                .filter(winningType ->
                        correctCount == winningType.getMatchCount())
                .findAny()
                .orElse(NOT_MATCH);
    }
}