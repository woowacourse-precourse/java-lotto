package lotto.utils.view;

import lotto.utils.constant.Messages;

public class InputView {

    public static void showPurchaseInputMessage() {
        System.out.println(Messages.PURCHASE_INPUT_MESSAGE);
    }

    public static void showWinningNumberInputMessage() {
        System.out.println(Messages.ENTER + Messages.WINNING_NUMBER_INPUT_MESSAGE);
    }

    public static void showBonusNumberInputMessage() {
        System.out.println(Messages.ENTER + Messages.BONUS_INPUT_MESSAGE);
    }
}
