package lotto;

public class WinInfo{
    private int matchCnt;
    private int bonusMatchCnt;
    private long winMoney;
    public WinInfo(int matchCnt, int bonusMatchCnt, long winMoney){
        this.matchCnt = matchCnt;
        this.bonusMatchCnt = bonusMatchCnt;
        this.winMoney = winMoney;
    }
}