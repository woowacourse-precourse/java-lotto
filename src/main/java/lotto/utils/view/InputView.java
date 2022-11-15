package lotto.utils.view;

import static lotto.utils.constant.Messages.*;

public class InputView {

    public static void showPurchaseInputMessage() {
        System.out.println(PURCHASE_INPUT_MESSAGE);
    }

    public static void showWinningNumberInputMessage() {
        System.out.println(ENTER + WINNING_NUMBER_INPUT_MESSAGE);
    }

    public static void showBonusNumberInputMessage() {
        System.out.println(ENTER + BONUS_INPUT_MESSAGE);
    }
}
