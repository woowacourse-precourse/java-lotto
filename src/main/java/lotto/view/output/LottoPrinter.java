package lotto.view.output;

import static lotto.view.output.LottoFormat.errorMessage;
import static lotto.view.output.LottoFormat.lottoTickets;
import static lotto.view.output.LottoFormat.purchasedNumberOfLottoTickets;
import static lotto.view.output.LottoFormat.winningStatistics;

import java.util.Map;
import lotto.domain.winning.LottoTickets;
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
        System.out.println(errorMessage(message));
    }

    public void printWinningStatistics(Map<Ranking, Integer> results, double rateOfReturn) {
        System.out.println(winningStatistics(results, rateOfReturn));
    }

    public void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println(
                purchasedNumberOfLottoTickets(lottoTickets.totalCounts())
        );

        System.out.println(
                lottoTickets(lottoTickets.lottoTickets())
        );
    }
}
