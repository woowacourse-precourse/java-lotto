package lotto.view;

import lotto.domain.LottoProfitRate;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTotalWinnings;
import lotto.model.Lotto;
import lotto.model.LottoBuyer;
import lotto.model.LottoResults;
import lotto.model.LottoWinningNumber;

public class LottoOutputView {
    private static String CONFIRM_BUY_AMOUNT_MESSAGE = "%d개를 구매했습니다.\n";
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
        System.out.printf(CONFIRM_BUY_AMOUNT_MESSAGE, lottoBuyer.getTotalLottoTickets());
    }

    public void printLottoInfo(LottoBuyer lottoBuyer) {
        lottoBuyer.getLottoTickets().stream().
                map(Lotto::getLotto).
                forEach(System.out::println);
    }


    private void printRankingResult(LottoResults lottoResults) {
        System.out.println("3개 일치 (5,000원) - " + lottoResults.getLottoPrizeCount("FIFTH_PLACE") + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoResults.getLottoPrizeCount("FOURTH_PLACE") + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoResults.getLottoPrizeCount("THIRD_PLACE") + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResults.getLottoPrizeCount("SECOND_PLACE") + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoResults.getLottoPrizeCount("FIRST_PLACE") + "개");
    }


    public void printLottoProfitRate(LottoBuyer lottoBuyer) {
        lottoTotalWinnings.getTotalWinnings(lottoBuyer);
        double profitRate = lottoProfitRate.getProfitRate(lottoBuyer.getTotalWinnings(), lottoBuyer.getPayment());
        System.out.printf(PROFIT_RATE_MESSAGE, profitRate);
    }
}
