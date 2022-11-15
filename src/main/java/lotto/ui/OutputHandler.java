package lotto.ui;

import lotto.domain.LottoReward;
import lotto.domain.Player;
import lotto.domain.Statistics;
import lotto.message.PrintMessage;

import java.util.List;
import java.util.Map;

public class OutputHandler {

    private final Statistics statistics;

    public OutputHandler(List<LottoReward> lottoRewards, Player player) {
        this.statistics = new Statistics(lottoRewards, player);
        statistics.analysis();
    }

    public void showStatistics() {
        System.out.println(PrintMessage.MESSAGE_STATISTICS);
        System.out.println(PrintMessage.MESSAGE_LINE);

        Map<LottoReward, Integer> winningHistory = statistics.getWinningHistory();
        showWinningHistory(winningHistory);
        showRateOfReturn();
    }

    private void showWinningHistory(Map<LottoReward, Integer> winningHistory) {
        System.out.printf(PrintMessage.MESSAGE_FIFTH.getMessage(),
                LottoReward.FIFTH.REWARD, winningHistory.get(LottoReward.FIFTH));
        System.out.printf(PrintMessage.MESSAGE_FOURTH.getMessage(),
                LottoReward.FOURTH.REWARD, winningHistory.get(LottoReward.FOURTH));
        System.out.printf(PrintMessage.MESSAGE_THIRD.getMessage(),
                LottoReward.THIRD.REWARD, winningHistory.get(LottoReward.THIRD));
        System.out.printf(PrintMessage.MESSAGE_SECOND.getMessage(),
                LottoReward.SECOND.REWARD, winningHistory.get(LottoReward.SECOND));
        System.out.printf(PrintMessage.MESSAGE_FIRST.getMessage(),
                LottoReward.FIRST.REWARD, winningHistory.get(LottoReward.FIRST));
    }

    private void showRateOfReturn() {
        System.out.printf(PrintMessage.MESSAGE_RATE_OF_RETURN.getMessage(), statistics.getRateOfReturn());
    }
}
