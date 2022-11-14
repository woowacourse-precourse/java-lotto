package lotto.domain.menu;

import java.util.List;
import lotto.constants.SystemConsole;
import lotto.domain.TotalPrizeMoney;
import lotto.domain.WinningStatistics;
import lotto.domain.YieldCalculation;

public class RankingWinner {

    private final TotalPrizeMoney totalPrizeMoney;
    private final YieldCalculation yieldCalculation;
    private final WinningStatistics winningStatistics;

    public RankingWinner(WinningStatistics winningStatistics, TotalPrizeMoney totalPrizeMoney,
            YieldCalculation yieldCalculation) {
        this.winningStatistics = winningStatistics;
        this.totalPrizeMoney = totalPrizeMoney;
        this.yieldCalculation = yieldCalculation;
    }

    public void findAWinner(List<Integer> sameNumberCount, List<Integer> bonusNumbers) {
        List<Integer> winningRanking = winningStatistics.countCheck(sameNumberCount, bonusNumbers);  // ok

        SystemConsole systemConsole = new SystemConsole();
        systemConsole.WINNING_STATISTICS();

        for (int i = 0; i < winningRanking.size(); i++) {
            SystemConsole(winningRanking, systemConsole, i);
        }

        int calculation = totalPrizeMoney.totalCalculation(sameNumberCount, winningRanking);
        double revenue = yieldCalculation.revenue(calculation);
        systemConsole.GROSS_YIELDS(revenue);
    }

    private void systemConsole(List<Integer> winningRanking, SystemConsole systemConsole) {
        for (Rank rank : Rank.values()) {
            int rankIndex = rank.ordinal();
            int c = winningRanking.get(rankIndex);

            if (rank == Rank.SECOND) {
                systemConsole.WINNING_RANKING_SECOND(c, rank.getMatch(), rank.getMoney());
                continue;
            }

            systemConsole.WINNING_RANKING(c, rank.getMatch(), rank.getMoney());
        }
    }
}