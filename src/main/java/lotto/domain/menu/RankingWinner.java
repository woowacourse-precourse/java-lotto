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

    public List<Integer> findAWinner(List<Integer> sameNumberCount, List<Integer> bonusNumbers) {
        List<Integer> winningRanking = winningStatistics.countCheck(sameNumberCount, bonusNumbers);

        SystemConsole systemConsole = new SystemConsole();
        systemConsole.WINNING_STATISTICS();

        for (int i = 0; i < winningRanking.size(); i++) {
            SystemConsole(winningRanking, systemConsole, i);
        }

        int calculation = totalPrizeMoney.totalCalculation(sameNumberCount, winningRanking);
        double revenue = yieldCalculation.revenue(calculation);
        systemConsole.GROSS_YIELDS(revenue);

        return null;
    }

    private void SystemConsole(List<Integer> winningRanking, SystemConsole systemConsole, int i) {

        if (i == 0) {
            systemConsole.WINNING_RANKING_FIFTH(winningRanking, i);
        }

        if (i == 1) {
            systemConsole.WINNING_RANKING_FOURTH(winningRanking, i);
        }

        if (i == 2) {
            systemConsole.WINNING_RANKING_THIRD(winningRanking, i);
        }

        if (i == 3) {
            systemConsole.WINNING_RANKING_SECOND(winningRanking, i);
        }

        if (i == 4) {
            systemConsole.WINNING_RANKING_FIRST(winningRanking, i);
        }
    }
}