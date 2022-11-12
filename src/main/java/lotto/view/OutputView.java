package lotto.view;

import lotto.domain.Lotto;
import lotto.resources.LottoResultMessage;

import java.math.BigDecimal;
import java.util.List;

public class OutputView {
    private final String WINNING_STATISTIC = "당첨통계\n----";
    private final String FIRST_DECIMAL_PLACE = "%.1f";
    private final String IS_NUMBER_OF_PURCHASE = "%d개를 구매했습니다.\n";
    private final String NEWLINE = "";

    public void printLottoPurchaseInformation(List<Lotto> myLotto, int lottoIssueCount) {
        System.out.printf(IS_NUMBER_OF_PURCHASE, lottoIssueCount);

        for (int count = 0; count < lottoIssueCount; count++) {
            System.out.println(myLotto.get(count).getLottoNumbers().toString());
        }
        System.out.println(NEWLINE);
    }

    public void printLottoResult(List<Integer> result, double earningsRate) {
        printWinningStatistic(result);
        printTotalEarningsRate(earningsRate);
    }

    private void printTotalEarningsRate(double earningsRate) {
        String rate = String.format(FIRST_DECIMAL_PLACE, new BigDecimal(earningsRate));
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }

    private void printWinningStatistic(List<Integer> result) {
        System.out.println(WINNING_STATISTIC);
        for (LottoResultMessage resultMessage : LottoResultMessage.values()) {
            System.out.println(resultMessage.getMessage() + result.get(resultMessage.getRank()) + "개");
        }
    }
}
