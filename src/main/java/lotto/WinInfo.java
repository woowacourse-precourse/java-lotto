package lotto;

public class WinInfo {
    private int matchCnt;
    private int bonusMatchCnt;
    private long winMoney;

    public WinInfo(int matchCnt, int bonusMatchCnt, long winMoney) {
        this.matchCnt = matchCnt;
        this.bonusMatchCnt = bonusMatchCnt;
        this.winMoney = winMoney;
    }

    public boolean match(int matchCnt, int bonusMatchCnt) {
        if (this.matchCnt == matchCnt && this.bonusMatchCnt == bonusMatchCnt) {
            return true;
        }
        return false;
    }
}