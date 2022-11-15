package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.UserInputValidator;

import static lotto.utils.Constants.*;

public class InputView {
    public static int inputPurchaseAmount() {
        System.out.println(INPUT_MESSAGE_PURCHASE_AMOUNT);
        String userInput = Console.readLine();
        UserInputValidator.validatePurchaseAmount(userInput);
        return Integer.parseInt(userInput);
    }
}
