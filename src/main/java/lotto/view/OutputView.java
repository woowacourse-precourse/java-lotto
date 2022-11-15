package lotto.view;

import lotto.domain.Lotto;
import lotto.LottoRank;
import lotto.domain.LottoStatics;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

public class OutputView {
    private final static String PURCHASE_LOG = "%d개를 구매했습니다.";
    private final static String WIN_STATICS = "당첨 통계\n---";
    private final static String WIN_RESULT = "%d개 일치 (%s원) - %d개";
    private final static String SECOND_PLACE_RESULT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private final static String RATE_OF_PROFIT = "총 수익률은 %.1f%%입니다.";

    public void print(List<Lotto> lotteries) {
        String purchaseLog = String.format(PURCHASE_LOG, lotteries.size());
        System.out.println(purchaseLog);
        lotteries.forEach(lotto -> System.out.println(lotto.toString()));
        printNewLine();
    }

    public void print(LottoStatics lottoStatics) {
        printWinStatics(lottoStatics.rankStatics());
        printProfitRate(lottoStatics.profitRate());
    }

    private void printWinStatics(HashMap<LottoRank, Integer> lottoRankStatics) {
        System.out.println(WIN_STATICS);
        DecimalFormat formatter = new DecimalFormat("###,###");

        for (LottoRank lottoRank : LottoRank.values()) {
            String winResultFormat = WIN_RESULT;
            if (lottoRank == LottoRank.SECOND_PLACE) {
                winResultFormat = SECOND_PLACE_RESULT;
            }
            System.out.printf(winResultFormat, lottoRank.matchNumberCount, formatter.format(lottoRank.price), lottoRankStatics.get(lottoRank));
            printNewLine();
        }
    }

    private void printNewLine() {
        System.out.println();
    }

    private void printProfitRate(float rateOfProfit) {
        System.out.printf(RATE_OF_PROFIT, rateOfProfit);
    }
}
