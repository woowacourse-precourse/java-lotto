package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.util.constants.GameConstants;
import lotto.util.constants.WinningScore;

public class GameMessage {

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

    public void printLottoNumber(List<Integer> lotto) {
        String[] lottoArray = lotto.stream().map(String::valueOf).toArray(String[]::new);
        print(Arrays.toString(lottoArray));
    }

    public void printStatistics(Map<WinningScore, Integer> statistics) {
        print("\n" + GameConstants.OUTPUT_WINNING_STATS);
        for (WinningScore winningScore : WinningScore.values()) {
            int count = statistics.get(winningScore);
            print(winningScore.printWinningScore() + " - " + count + "개");
        }
    }

    public void printRateOfReturn(double rateOfReturn) {
        print(String.format("총 수익률은 %.1f%%입니다.", rateOfReturn));
    }

    public void print(String printString) {
        System.out.println(printString);
    }
}
