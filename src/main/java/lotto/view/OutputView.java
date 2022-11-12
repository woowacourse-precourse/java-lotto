package lotto.view;

import lotto.Lotto;
import lotto.LottoRank;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

public class OutputView {
    private final static String PURCHASE_LOG = "%d개를 구매했습니다.";
    private final static String WIN_STATICS = "당첨 통계\n---";
    private final static String WIN_RESULT = "%d개 일치 (%s원) - %d개";
    private final static String SECOND_PLACE_RESULT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";

    public void printLotteries(List<Lotto> lotteries) {
        String purchaseLog = String.format(PURCHASE_LOG, lotteries.size());
        System.out.println(purchaseLog);
        lotteries.forEach(lotto -> System.out.println(lotto.toString()));
    }

    public void printWinStatics(HashMap<LottoRank, Integer> lottoRankStatics) {
        System.out.println(WIN_STATICS);
        DecimalFormat formatter = new DecimalFormat("###,###");
        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank == LottoRank.SECOND_PLACE) {
                System.out.printf(SECOND_PLACE_RESULT, lottoRank.matchNumberCount, formatter.format(lottoRank.price), lottoRankStatics.get(lottoRank));
                printNewLine();
                continue;
            }
            System.out.printf(WIN_RESULT, lottoRank.matchNumberCount, formatter.format(lottoRank.price), lottoRankStatics.get(lottoRank));
            printNewLine();
        }
    }

    private void printNewLine() {
        System.out.println();
    }
}
