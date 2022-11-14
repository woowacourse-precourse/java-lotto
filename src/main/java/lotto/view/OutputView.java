package lotto.view;

import lotto.domain.Lotto;

import static lotto.constant.OutputConstants.*;

public class OutputView {

    public static void printPurchaseQuantity(int purchaseQuantity) {
        System.out.println();
        System.out.printf(PURCHASE_QUANTITY.toString(), purchaseQuantity);
        System.out.println();
    }

    public static void printLottoNumber(Lotto lotto) {
        System.out.println(lotto);
    }

    public static void printStatistics() {
        System.out.println();
        System.out.println(STATISTICS);
    }

    public static void printResult(String result) {
        System.out.println(result);
    }

    public static void printProfitRate(float profitRate) {
        System.out.printf(PROFIT_RATE.toString(), profitRate);
        System.out.println();
    }
}
