package lotto.domain;

import java.util.List;

public class WinCheck {
    private int matchCount;
    private boolean isBonusMatch;

    public WinCheck(Lotto lotto, List<Integer> winNums, int bonusNum) {
        this.matchCount = 0;
        for (int e : lotto.getNums()) {
            if (winNums.contains(e))
                this.matchCount++;
            if (bonusNum == e)
                this.isBonusMatch = true;
        }
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return isBonusMatch;
    }
}