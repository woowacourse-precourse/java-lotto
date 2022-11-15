package lotto.domain.menu;

import java.util.List;
import lotto.constants.Rank;
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
        List<Integer> winningRanking = winningStatistics.countCheck(sameNumberCount,
                bonusNumbers);

        SystemConsole systemConsole = getSystemConsole(winningRanking);

        int calculation = totalPrizeMoney.totalCalculation(sameNumberCount, winningRanking);
        double revenue = yieldCalculation.revenue(calculation);
        systemConsole.grossYields(revenue);
    }

    private SystemConsole getSystemConsole(List<Integer> winningRanking) {
        SystemConsole systemConsole = new SystemConsole();
        systemConsole.winningStatistics();
        systemConsole(winningRanking, systemConsole);
        return systemConsole;
    }

    private void systemConsole(List<Integer> winningRanking, SystemConsole systemConsole) {
        for (Rank rank : Rank.values()) {
            int rankIndex = rank.ordinal();
            int rankCount = winningRanking.get(rankIndex);

            if (rank == Rank.SECOND) {
                systemConsole.winningRankingSecond(rankCount, rank.getMatch(), rank.getMoney());
                continue;
            }
            systemConsole.winningRanking(rankCount, rank.getMatch(), rank.getMoney());
        }
    }
}