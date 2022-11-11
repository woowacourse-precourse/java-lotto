package lotto.domain.view;

import static lotto.domain.view.IOMessage.OUTPUT_LOTTO_RESULT_HEAD;
import static lotto.domain.view.IOMessage.OUTPUT_PURCHASE_LOTTO;
import static lotto.domain.view.IOMessage.OUTPUT_YIELD_MESSAGE;

import java.util.List;
import java.util.Map;
import lotto.domain.model.LottoRank;
import lotto.domain.model.LottoResult;
import lotto.domain.model.Pay;
import lotto.domain.model.UserLotto;

public abstract class OutputData {

    public static void printUserLotto(UserLotto userLotto) {
        System.out.println();
        System.out.println(userLotto.getUserLottoSize() + OUTPUT_PURCHASE_LOTTO.getMessage());
        for (String lotto : userLotto.getUserLotto()) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void printLottoResult(LottoResult lottoResult, Pay pay) {
        System.out.println();
        System.out.println(OUTPUT_LOTTO_RESULT_HEAD.getMessage());
        printStatistics(lottoResult);
        printYield(lottoResult, pay);
        System.out.println();
    }

    private static void printStatistics(LottoResult lottoResult) {
        Map<LottoRank, Long> result = lottoResult.getLottoResult();
        for (LottoRank lottoRank : result.keySet()) {
            System.out.println(LottoRank.createStatisticsForm(lottoRank, result.get(lottoRank)));
        }
    }

    private static void printYield(LottoResult lottoResult, Pay pay) {
        System.out.println(
                String.format(OUTPUT_YIELD_MESSAGE.getMessage(), Math.round(lottoResult.calculateYield(pay) * 10) / 10.0));

    }
}
