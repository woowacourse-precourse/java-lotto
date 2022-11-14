package lotto.domain.view;

import static lotto.domain.view.IOMessage.OUTPUT_LOTTO_RESULT_HEAD;
import static lotto.domain.view.IOMessage.OUTPUT_PURCHASE_LOTTO;
import static lotto.domain.view.IOMessage.OUTPUT_YIELD_MESSAGE;

import java.util.Map;
import lotto.domain.model.LottoRank;
import lotto.domain.model.LottoResult;
import lotto.domain.model.Pay;
import lotto.domain.model.UserLotto;

public abstract class OutputData {

    public static final double PERCENT_NUMBER = 10.0;

    public static void printUserLotto(final UserLotto userLotto, final Pay pay) {
        System.out.println();
        System.out.println(pay.calculateQuantity() + OUTPUT_PURCHASE_LOTTO.getMessage());
        for (String lotto : userLotto.getUserLotto()) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void printLottoResult(final LottoResult lottoResult, final Pay pay) {
        System.out.println();
        System.out.println(OUTPUT_LOTTO_RESULT_HEAD.getMessage());
        printStatistics(lottoResult);
        printYield(lottoResult, pay);
        System.out.println();
    }

    private static void printStatistics(final LottoResult lottoResult) {
        Map<LottoRank, Long> result = lottoResult.getLottoResult();
        for (LottoRank lottoRank : result.keySet()) {
            System.out.println(LottoRank.createStatisticsForm(lottoRank, result.get(lottoRank)));
        }
    }

    private static void printYield(final LottoResult lottoResult, final Pay pay) {
        System.out.printf((OUTPUT_YIELD_MESSAGE.getMessage()) + "%n",
                Math.round(lottoResult.calculateYield(pay) * PERCENT_NUMBER) / PERCENT_NUMBER);

    }
}
