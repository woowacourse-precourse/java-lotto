package lotto.view;

import lotto.Lotto;

import static lotto.constant.OutputConstants.*;

public class OutputView {

    public static void printPurchaseAmountMessage() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
    }

    public static void printPurchaseQuantity(int purchaseQuantity) {
        System.out.println();
        System.out.printf(PURCHASE_QUANTITY.toString(), purchaseQuantity);
        System.out.println();
    }

    public static void printLottoNumber(Lotto lotto) {
        System.out.println(lotto);
    }

    public static void printWinningNumber() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBER);
    }
}
