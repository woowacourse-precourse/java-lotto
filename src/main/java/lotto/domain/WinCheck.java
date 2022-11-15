package lotto.domain;

import java.util.List;

public class WinCheck {
    private int matchCount;
    private boolean isBonusMatch;

    public WinCheck(Lotto lotto, List<Integer> winNums, int bonusNum) {
        this.matchCount = 0;
        this.isBonusMatch = false;
        for (int e : lotto.getNums()) {
            if (winNums.contains(e))
                this.matchCount++;
            if (bonusNum == e)
                this.isBonusMatch = true;
        }
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public boolean isBonusMatch() {
        return this.isBonusMatch;
    }

    public static void checkSave() {
        for (Lotto e : StartLotto.lotto) {
            WinCheck newWinCheck = new WinCheck(e, StartLotto.winNums, StartLotto.bonusNum);
            StartLotto.winChecks.add(newWinCheck);
        }
    }
}