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

    public int winMoney() {
        if (matchCnt == 3)
            return 5000;
        if (matchCnt == 4)
            return 50000;
        if (matchCnt == 5) {
            if (isBonusMatch())
                return 1500000;
            return 30000000;
        }
        if (matchCnt == 6)
            return 2000000000;
        return 0;
    }
}