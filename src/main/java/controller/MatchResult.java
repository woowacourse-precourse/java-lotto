package controller;

public class MatchResult {

    private final boolean isHavingBonus;
    private final int winningCount;

    public MatchResult(int winningCount, boolean isHavingBonus) {
        this.isHavingBonus = isHavingBonus;
        this.winningCount = winningCount;
    }

    public boolean getIsHavingBonus() {
        return isHavingBonus;
    }

    public int getWinningNumberCount() {
        return winningCount;
    }
}
