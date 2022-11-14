package lotto;

public class WinInfo {

    private int matchCnt;
    private int bonusMatchCnt;
    private long winMoney;
    private int order;

    public WinInfo(int matchCnt, int bonusMatchCnt, long winMoney, int order) {
        this.matchCnt = matchCnt;
        this.bonusMatchCnt = bonusMatchCnt;
        this.winMoney = winMoney;
        this.order = order;
    }

    public boolean match(int matchCnt, int bonusMatchCnt) {
        if (this.matchCnt == matchCnt && this.bonusMatchCnt == bonusMatchCnt) {
            return true;
        }
        return false;
    }
}