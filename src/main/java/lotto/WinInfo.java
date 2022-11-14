package lotto;

public enum WinInfo {

    NO_WIN(-1, -1, 0, -1),
    WIN1(6, 0, 2000000000, 1),
    WIN2(5, 1, 30000000, 2),
    WIN3(5, 0, 1500000, 3),
    WIN4(4, 0, 50000, 4),
    WIN5(3, 0, 5000, 5);

    private int matchCnt;
    private int bonusMatchCnt;
    private long winMoney;
    private int order;

    WinInfo(int matchCnt, int bonusMatchCnt, long winMoney, int order) {
        this.matchCnt = matchCnt;
        this.bonusMatchCnt = bonusMatchCnt;
        this.winMoney = winMoney;
        this.order = order;
    }

    public boolean match(int matchCnt, int bonusMatchCnt) {
        if (this.matchCnt == matchCnt && this.bonusMatchCnt <= bonusMatchCnt) {
            return true;
        }
        return false;
    }

    public static WinInfo get(int matchCnt, int bonusMatchCnt) {
        for (WinInfo winInfo : WinInfo.values()) {
            if (winInfo.match(matchCnt, bonusMatchCnt)) {
                return winInfo;
            }
        }
        return WinInfo.NO_WIN;
    }

}