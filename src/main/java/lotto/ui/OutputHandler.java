package lotto.ui;

import lotto.domain.LottoReward;
import lotto.domain.Player;
import lotto.domain.Statistics;

import java.util.List;
import java.util.Map;

public class OutputHandler {

    private final Statistics statistics;

    public OutputHandler(List<LottoReward> lottoRewards, Player player) {
        this.statistics = new Statistics(lottoRewards, player);
        statistics.analysis();
    }

    public void showStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");

        Map<LottoReward, Integer> winningHistory = statistics.getWinningHistory();
        showWinningHistory(winningHistory);
        showRateOfReturn();
    }

    private void showWinningHistory(Map<LottoReward, Integer> winningHistory) {
        System.out.printf("3개 일치 (%,d원) - %d개\n", LottoReward.FIFTH.REWARD, winningHistory.get(LottoReward.FIFTH));
        System.out.printf("4개 일치 (%,d원) - %d개\n", LottoReward.FOURTH.REWARD, winningHistory.get(LottoReward.FOURTH));
        System.out.printf("5개 일치 (%,d원) - %d개\n", LottoReward.THIRD.REWARD, winningHistory.get(LottoReward.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (%,d원) - %d개\n",
                LottoReward.SECOND.REWARD, winningHistory.get(LottoReward.SECOND));
        System.out.printf("6개 일치 (%,d원) - %,d개\n", LottoReward.FIRST.REWARD, winningHistory.get(LottoReward.FIRST));
    }

    private void showRateOfReturn() {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", statistics.getRateOfReturn());
    }
}
