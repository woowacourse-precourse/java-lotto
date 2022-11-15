package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public enum WinStatistics {

    UNSUCCESSFUL(0, "0"),
    FIFTH(3, "5,000원"),
    FOURTH(4, "50,000원"),
    THIRD(5, "1,500,000원"),
    SECOND(5, "30,000,000원"),
    FIRST(6, "2,000,000,000원");

    private final int matchCount;
    private final String prizeMoney;

    WinStatistics(final int matchCount, final String prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static WinStatistics winCounter(int matchCount, boolean bonusNumber) {
        if (matchCount == WinStatistics.SECOND.matchCount) {
            return isBonusNumber(bonusNumber);
        }

        for (WinStatistics winValue : WinStatistics.values()) {
            if (winValue.matchCount == matchCount) {
                return winValue;
            }
        }
        return WinStatistics.UNSUCCESSFUL;
    }

    public static WinStatistics isBonusNumber(boolean bonusNumber) {
        if (bonusNumber) {
            return WinStatistics.SECOND;
        }
        return WinStatistics.THIRD;
    }

    public static void showWinStatistics(Map<WinStatistics, Long> lottoStatisticsMap) {
        for (WinStatistics winStatistics : WinStatistics.values()) {
            if (winStatistics == SECOND) {
                System.out.println(winStatistics.matchCount + "개 일치, 보너스 볼 일치 (" + winStatistics.prizeMoney + ") - " + lottoStatisticsMap.get(winStatistics) + "개");
                continue;
            }
            if (winStatistics == UNSUCCESSFUL) {
                continue;
            }
            System.out.println(winStatistics.matchCount + "개 일치 (" + winStatistics.prizeMoney + ") - " + lottoStatisticsMap.get(winStatistics) + "개");
        }
    }

    public static void calculateProfit(Map<WinStatistics, Long> lottoStatisticsMap) {
        List<Integer> prizeList = new ArrayList<>(List.of(0, 5000, 50000, 1500000, 30000000, 2000000000));
        long profit = 0;
        long lottoCount = 0;
        int i = 0;
        for (WinStatistics winStatistics : WinStatistics.values()) {
            profit += lottoStatisticsMap.get(winStatistics) * prizeList.get(i);
            lottoCount += lottoStatisticsMap.get(winStatistics);
            i++;
        }
        showProfitLotto(profit, lottoCount);
    }

    public static void showProfitLotto(double profit, long lottoCount) {
        double result = profit / (lottoCount * 1000) * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", result) + "%입니다.");
    }

}
