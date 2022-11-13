package lotto.domain.menu;

import java.util.List;
import lotto.domain.TotalPrizeMoney;
import lotto.domain.WinningStatistics;
import lotto.domain.YieldCalculation;
import lotto.print.RankPrint;

public class RankingWinner {

    private final TotalPrizeMoney totalPrizeMoney;
    private final YieldCalculation yieldCalculation;
    private final WinningStatistics winningStatistics;

    public RankingWinner(WinningStatistics winningStatistics,TotalPrizeMoney totalPrizeMoney, YieldCalculation yieldCalculation) {
        this.winningStatistics = winningStatistics;
        this.totalPrizeMoney = totalPrizeMoney;
        this.yieldCalculation = yieldCalculation;
    }

    public List<Integer> findAWinner(List<Integer> sameNumberCount, List<Integer> bonusNumbers) {
        List<Integer> winningRanking = winningStatistics.countCheck(sameNumberCount, bonusNumbers);

        RankPrint rankPrint = new RankPrint();
        rankPrint.print(winningRanking);

        int calculation = totalPrizeMoney.totalCalculation(sameNumberCount, winningRanking);
        double revenue = yieldCalculation.revenue(calculation);
        return null;
    }
}