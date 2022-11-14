package lotto.view;

import static lotto.Constants.ASK_BONUS_NUMBER;
import static lotto.Constants.ASK_PURCHASE_AMOUNT;
import static lotto.Constants.ASK_WINNING_NUMBERS;

public class OutputView {
    public static void printAskPurchaseAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT);
    }

    public static void printAskWinningNumbers() {
        System.out.println(ASK_WINNING_NUMBERS);
    }

    public static void printAskBonusNumber() {
        System.out.println(ASK_BONUS_NUMBER);
    }
}
