package lotto.domain.winning.statistic;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.winning.WinningRank;
import lotto.util.Calculator;
import lotto.util.View;

public class WinningStatisticView {
    
    public static void printAll(WinningStatistic winningStatistic, Integer purchaseAmount) {
        printStartMessage();
        printWinningList(winningStatistic);
        printRateOfReturn(winningStatistic, purchaseAmount);
    }
    
    public static void printStartMessage() {
        View.println("당첨 통계");
        View.println("---");
    }
    
    public static void printWinningList(WinningStatistic winningStatistic) {
        getWinningTextList(WinningRank.getSortedListByRankASC(), winningStatistic.getWinningCountByRank()).forEach(
                View::println);
    }
    
    public static void printRateOfReturn(WinningStatistic winningStatistic, Integer purchaseAmount) {
        View.println("총 수익률은 " + getTextByRateOfReturn(winningStatistic, purchaseAmount) + "입니다.");
    }
    
    public static String getTextByRateOfReturn(WinningStatistic winningStatistic, Integer purchaseAmount) {
        return formatRating(Calculator.getRateOfReturn(purchaseAmount, winningStatistic.getTotalReward()));
    }
    
    public static List<String> getWinningTextList(List<WinningRank> ranks, Map<Integer, Integer> winningCountByRank) {
        return ranks.stream().map((winningRank -> getWinningTextByRank(winningRank,
                winningCountByRank.getOrDefault(winningRank.getRank(), 0)))).collect(Collectors.toList());
    }
    
    private static String getWinningTextByRank(WinningRank winningRank, Integer count) {
        String normalMatchText = winningRank.getCountNormalMatch() + "개 일치";
        String bonusMatchText = "";
        
        if (winningRank.getCountBonusMatch() > 0) {
            bonusMatchText = ", 보너스 볼 일치";
        }
        
        String detailText = " (" + formatPrice(winningRank.getReward()) + ") - " + count + "개";
        
        return normalMatchText + bonusMatchText + detailText;
    }
    
    private static String formatRating(Double target) {
        return new DecimalFormat("###,##0.0").format(target) + "%";
    }
    
    private static String formatPrice(Integer target) {
        return new DecimalFormat("###,###").format(target) + "원";
    }
}
