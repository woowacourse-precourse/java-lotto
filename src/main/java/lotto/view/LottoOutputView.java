package lotto.view;

import lotto.domain.LottoProfitRate;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTotalWinnings;
import lotto.utils.LottoRanking;
import lotto.model.Lotto;
import lotto.model.LottoBuyer;
import lotto.model.LottoResults;
import lotto.model.LottoWinningNumber;

public class LottoOutputView {
    private static String BUY_AMOUNT_MESSAGE = "%d개를 구매했습니다.\n";
    private static String STATISTIC_MESSAGE = "당첨 통계\n---";
    private static String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.\n";

    LottoProfitRate lottoProfitRate = new LottoProfitRate();
    LottoStatistics lottoStatistics = new LottoStatistics();
    LottoTotalWinnings lottoTotalWinnings = new LottoTotalWinnings();

    public void printLottoStatistics(LottoBuyer lottoBuyer, LottoWinningNumber lottoWinningNumber) {
        System.out.println(STATISTIC_MESSAGE);
        lottoStatistics.getLottoStatistics(lottoBuyer, lottoWinningNumber);
        printRankingResult(lottoBuyer.getLottoResults());
    }

    public void printBuyAmount(LottoBuyer lottoBuyer) {
        System.out.printf(BUY_AMOUNT_MESSAGE, lottoBuyer.getTotalLottoTickets());
    }

    public void printLottoInfo(LottoBuyer lottoBuyer) {
        lottoBuyer.getLottoTickets().stream().
                map(Lotto::getLotto).
                forEach(System.out::println);
    }


    private void printRankingResult(LottoResults lottoResults) {
        for (LottoRanking rank : LottoRanking.values()) {
            System.out.printf(rank.getMessage(), lottoResults.getLottoPrizeCount(rank.toString()));
        }
    }


    public void printLottoProfitRate(LottoBuyer lottoBuyer) {
        lottoTotalWinnings.getTotalWinnings(lottoBuyer);
        double profitRate = lottoProfitRate.getProfitRate(lottoBuyer.getTotalWinnings(), lottoBuyer.getPayment());
        System.out.printf(PROFIT_RATE_MESSAGE, profitRate);
    }
}
