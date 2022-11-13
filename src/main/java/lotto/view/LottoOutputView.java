package lotto.view;

import lotto.domain.LottoProfitRate;
import lotto.domain.LottoResult;
import lotto.model.Lotto;
import lotto.model.LottoBuyer;
import lotto.model.LottoWinningNumber;

import java.util.List;

public class LottoOutputView {
    private static String CONFIRM_BUY_AMOUNT_MESSAGE = "%d개를 구매했습니다.\n";
    private static String STATISTIC_MESSAGE = "당첨 통계\n---";
    private static String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.\n";
    LottoProfitRate lottoProfitRate = new LottoProfitRate();
    LottoResult lottoResult = new LottoResult();

    public void printLottoStatistics(LottoBuyer lottoBuyer, LottoWinningNumber lottoWinningNumber) {
        System.out.println(STATISTIC_MESSAGE);
        lottoResult.getLottoStatistics(lottoBuyer, lottoWinningNumber);
    }

    public void printBuyAmount(LottoBuyer lottoBuyer) {
        System.out.printf(CONFIRM_BUY_AMOUNT_MESSAGE, lottoBuyer.getTotalLottoTickets());
    }

    public void printLottoInfo(LottoBuyer lottoBuyer) {
        lottoBuyer.getLottoTickets().stream().
                map(Lotto::getLotto).
                forEach(System.out::println);
    }


    public void printLottoProfitRate(LottoBuyer lottoBuyer) {
        double profitRate = lottoProfitRate.getProfitRate(lottoBuyer.getTotalWinnings(), lottoBuyer.getPayment());
        System.out.printf(PROFIT_RATE_MESSAGE, profitRate);
    }
}
