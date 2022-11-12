package lotto;

import java.util.List;

public class Result {
    private int matchCnt;
    private boolean bonusMatch;

    public Result(Lotto lotto, List<Integer> winNums, int bonusNum) {
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