package lotto.domain;

import java.util.List;

public class WinCheck {
    private int matchCnt;
    private boolean bonusMatch;

    public WinCheck(Lotto lotto, List<Integer> winNums, int bonusNum) {
        this.matchCnt = 0;
        for (int e : lotto.getNums()) {
            if (winNums.contains(e))
                this.matchCnt++;
            if (bonusNum == e)
                this.bonusMatch = true;
        }
    }

    public int getMatchCnt() {
        return matchCnt;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

}