package lotto;

public class MatchCount {
    private int winningCount;
    private int bonusCount;

    public MatchCount(int winningCount, int bonusCount) {
        this.winningCount = winningCount;
        this.bonusCount = bonusCount;
    }

    public boolean isSameResult(MatchCount o) {
        if (winningCount==o.winningCount && bonusCount<=o.bonusCount) {
            return true;
        }
        return false;
    }
}
