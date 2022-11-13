package lotto.view;

import lotto.domain.Lotteries;
import lotto.domain.LottoResult;
import lotto.domain.Money;

public class outputView {
    public static void printBuyLotto(Money money) {
        System.out.printf("\n%d개를 구매했습니다.\n", money.getLottoAmount());
    }

    public static void printLotteries(Lotteries lotteries) {
        System.out.println(lotteries.toString());
    }

    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println("\n당첨 통계");
        System.out.print("---");
        System.out.println(lottoResult.toString());
    }
}
