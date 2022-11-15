package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.StatisticsResult;
import lotto.model.WinningScore;
import lotto.util.constants.GameConstants;

public class LottoOutputView {

    public void printInputPurchaseAmount() {
        print(GameConstants.INPUT_PURCHASE_AMOUNT);
    }

    public void printInputWinningNumber() {
        print("\n" + GameConstants.INPUT_WINNING_NUMBER);
    }

    public void printInputBonusNumber() {
        print("\n" + GameConstants.INPUT_BONUS_NUMBER);
    }

    public void printLottoTicketCount(int lottoTicketCount) {
        print("\n" + lottoTicketCount + GameConstants.OUTPUT_PURCHASE_LOTTO_COUNT);
    }

    public void printLottoTickets(List<Lotto> lottoTickets) {
        for (Lotto lottoTicket : lottoTickets) {
            printLottoNumber(lottoTicket.getNumbers());
        }
    }

    private void printLottoNumber(List<Integer> lotto) {
        String[] lottoArray = lotto.stream().map(String::valueOf).toArray(String[]::new);
        print(Arrays.toString(lottoArray));
    }

    public void printStatistics(StatisticsResult statistics) {
        print("\n" + GameConstants.OUTPUT_WINNING_STATS);
        for (WinningScore winningScore : WinningScore.values()) {
            printWinningScore(winningScore, statistics.getWinningScoreResult());
        }
    }

    private void printWinningScore(WinningScore winningScore, Map<WinningScore, Integer> statistics) {
        if (winningScore == WinningScore.NONE) {
            return;
        }
        int count = statistics.get(winningScore);
        print(winningScore.printWinningScore() + " - " + count + "개");
    }

    public void printRateOfReturn(double rateOfReturn) {
        print(String.format("총 수익률은 %.1f%%입니다.", rateOfReturn));
    }

    private void print(String printString) {
        System.out.println(printString);
    }
}
