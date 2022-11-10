package lotto;

import java.util.Objects;

public class MatchCount {
    private int winningCount;
    private int bonusCount;

    public MatchCount(int winningCount, int bonusCount) {
        this.winningCount = winningCount;
        this.bonusCount = bonusCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningCount, bonusCount);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MatchCount)) {
            return false;
        }
        MatchCount matchCount = (MatchCount) obj;
        return matchCount.winningCount == winningCount &&
                matchCount.bonusCount == bonusCount;
    }
}
