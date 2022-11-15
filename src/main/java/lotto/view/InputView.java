package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.LottoMessage;

public class InputView {
    public static String inputPurchasePrice() {
        System.out.println(LottoMessage.INPUT_PURCHASE_PRICE.getMessage());
        return getUserInput();
    }

    public static String inputWinningLotto() {
        System.out.println(LottoMessage.INPUT_WINNING_LOTTO.getMessage());
        return getUserInput();
    }

    public static String inputBonusNumber() {
        System.out.println(LottoMessage.INPUT_BONUS_NUMBER.getMessage());
        return getUserInput();
    }

    private static String getUserInput() {
        return Console.readLine();
    }
}
