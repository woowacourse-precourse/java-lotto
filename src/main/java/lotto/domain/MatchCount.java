package lotto.domain;

public class MatchCount {
    private int winningCount;
    private int bonusCount;

    public MatchCount(int winningCount, int bonusCount) {
        this.winningCount = winningCount;
        this.bonusCount = bonusCount;
    }

    public boolean isSameResult(MatchCount o) {
        if (winningCount != o.winningCount) {
            return false;
        }
        if (winningCount!=5 || bonusCount==o.bonusCount) {
            return true;
        }
        return false;
    }
}
