package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.UserInputValidator;

public class InputView {

    private static final String INPUT_MESSAGE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    public static int inputPurchaseAmount() {
        System.out.println(INPUT_MESSAGE_PURCHASE_AMOUNT);
        String userInput = Console.readLine();
        UserInputValidator.validatePurchaseAmount(userInput);
        return Integer.parseInt(userInput);
    }
}
