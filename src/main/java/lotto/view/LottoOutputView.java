package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.StatisticsResult;
import lotto.model.WinningScore;

public class LottoOutputView {

    public static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static final String OUTPUT_PURCHASE_LOTTO_COUNT = "개를 구매했습니다.";
    public static final String OUTPUT_WINNING_STATS = "당첨 통계\n---";


    private static final String NEWLINE = "\n";

    public void printInputPurchaseAmount() {
        print(INPUT_PURCHASE_AMOUNT);
    }

    public void printInputWinningNumber() {
        print(NEWLINE + INPUT_WINNING_NUMBER);
    }

    public void printInputBonusNumber() {
        print(NEWLINE + INPUT_BONUS_NUMBER);
    }

    public void printLottoTicketCount(int lottoTicketCount) {
        print(NEWLINE + lottoTicketCount + OUTPUT_PURCHASE_LOTTO_COUNT);
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
        print(NEWLINE + OUTPUT_WINNING_STATS);
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
