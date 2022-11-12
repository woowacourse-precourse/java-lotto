package lotto.view.output;

import static lotto.view.output.StringFormatter.errorMessageFormat;
import static lotto.view.output.StringFormatter.purchasedLottoTicketsFormat;
import static lotto.view.output.StringFormatter.purchasedNumberOfLottoTicketsFormat;
import static lotto.view.output.StringFormatter.winningStatisticsFormat;

import java.util.Map;
import lotto.domain.winning.PurchasedLottoTickets;
import lotto.domain.winning.Ranking;

public class LottoPrinter {

    public void printGuideMessageForPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printGuideMessageForWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printGuideMessageForBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printErrorMessage(String message) {
        System.out.println(errorMessageFormat(message));
    }

    public void printWinningStatistics(Map<Ranking, Integer> results, double rateOfReturn) {
        System.out.println(winningStatisticsFormat(results, rateOfReturn));
    }

    public void printPurchasedLottoTickets(PurchasedLottoTickets purchasedLottoTickets) {
        System.out.println(
                purchasedNumberOfLottoTicketsFormat(purchasedLottoTickets.totalCounts())
        );

        System.out.println(
                purchasedLottoTicketsFormat(purchasedLottoTickets.purchasedLottoTickets())
        );
    }
}
