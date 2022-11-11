package lotto;

public enum WinningType {
    THREE_MATCH(3),
    FOUR_MATCH(4),
    FIVE_MATCH(5),
    FIVE_WITH_BONUS_MATCH(5),
    SIX_MATCH(6);

    private final int matchCount;

    WinningType(int matchCount) {
        this.matchCount = matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
