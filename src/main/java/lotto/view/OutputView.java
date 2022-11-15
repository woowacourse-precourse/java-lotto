package lotto.view;

import lotto.Lotto;
import lotto.constant.OutputConstants;


public class OutputView {

    public static void printPurchaseQuantity(int purchaseQuantity) {
        System.out.println();
        System.out.printf(OutputConstants.PURCHASE_QUANTITY.toString(), purchaseQuantity);
        System.out.println();
    }

    public static void printLottoNumber(Lotto lotto) {
        System.out.println(lotto);
    }

    public static void printStatistics() {
        System.out.println();
        System.out.println(OutputConstants.STATISTICS);
    }

    public static void printPlaceResult(String result) {
        System.out.println(result);
    }

    public static void printProfitRate(float profitRate) {
        System.out.printf(OutputConstants.PROFIT_RATE.toString(), profitRate);
        System.out.println();
    }
}
