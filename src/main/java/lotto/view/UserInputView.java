package lotto.view;

import lotto.constant.UserInputMessage;

public class UserInputView {

    public static void printInputPurchasePrice() {
        System.out.println(UserInputMessage.INPUT_PURCHASE_PRICE.getMessage());
    }

    public static void printInputWinningLottoNumbers() {
        System.out.println(UserInputMessage.INPUT_WINNING_LOTTO_NUMBERS.getMessage());
    }

    public static void printInputBonusNumber() {
        System.out.println(UserInputMessage.INPUT_BONUS_NUMBER.getMessage());
    }
    
}
