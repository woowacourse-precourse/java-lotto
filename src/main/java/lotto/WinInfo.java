package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum WinInfo {

    NO_WIN(-1, -1, 0, 0),
    WIN1(6, 0, 2000000000, 1),
    WIN2(5, 1, 30000000, 2),
    WIN3(5, 0, 1500000, 3),
    WIN4(4, 0, 50000, 4),
    WIN5(3, 0, 5000, 5);


    private int matchCnt;
    private int bonusMatchCnt;
    private long winMoney;
    private int order;

    private static int totalCount = WinInfo.values().length;

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

    public static WinInfo getByOrder(int order) {
        for (WinInfo winInfo : WinInfo.values()) {
            if (winInfo.getOrder() == order) {
                return winInfo;
            }
        }
        throw new RuntimeException(String.format("WinInfo에 order=%d인 상수가 존재하지 않음", order));
    }

    public static Map<WinInfo, Integer> getStatistics(List<WinInfo> winInformations) {
        Map<WinInfo, Integer> result = new HashMap<>();
        for (WinInfo winInfo : WinInfo.values()) {
            result.put(winInfo, 0);
        }
        for (WinInfo winInfo : winInformations) {
            result.put(winInfo, result.get(winInfo) + 1);
        }
        return result;
    }

    public static int getTotalCount() {
        return totalCount;
    }

    public long getWinMoney() {
        return this.winMoney;
    }

    public int getMatchCnt() {
        return this.matchCnt;
    }

    public int getBonusMatchCnt() {
        return this.bonusMatchCnt;
    }

    public int getOrder() {
        return this.order;
    }
}