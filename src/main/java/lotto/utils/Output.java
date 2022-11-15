package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;

import java.util.List;

import static lotto.domain.Lotto.printLotto;
import static lotto.domain.ResultMessage.printLottoCountResult;

public class Output {
    public static void printLottoInfo(int lottoNum , List<Lotto> lottos) {
        System.out.println(Notice.NUMBER_OF_LOTTO.getMessage(lottoNum));
        printLotto(lottoNum, lottos);
    }

    public static void printResultMessage() {
        System.out.println(Notice.RESULT_OF_WINNING_LOTTO.getMessage());
        printLottoCountResult();
    }

    public static void printEarningRate(PurchaseAmount purchaseAmount) {
        String earningsRate = purchaseAmount.calculateEarningsRate();
        System.out.printf(Notice.EARNINGS_RATE.getMessage(), earningsRate);
    }
}
