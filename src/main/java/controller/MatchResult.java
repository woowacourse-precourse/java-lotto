package controller;

public class MatchResult {
    private boolean isHavingBonus;
    private int winningCount;

    public MatchResult(int winningCount, boolean isHavingBonus) {
        this.isHavingBonus = isHavingBonus;
        this.winningCount = winningCount;
    }

    public boolean getIsHavingBonus(){
        return isHavingBonus;
    }

    public int getBonusNumberCount(){
        return winningCount;
    }
}
