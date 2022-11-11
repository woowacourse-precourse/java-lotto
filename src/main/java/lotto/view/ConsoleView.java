package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.ConsoleMessage;
import lotto.validator.InputValidator;

public class ConsoleView {
    public static int inputPurchasePrice() {
        System.out.println(ConsoleMessage.INPUT_PURCHASE_PRICE.getMessage());
        String input = Console.readLine();
        return InputValidator.changeStringToInt(input);
    }

    public static void printPurchaseAmount(int amount) {
        String message = amount + ConsoleMessage.OUTPUT_PURCHASE_AMOUNT.getMessage();
        System.out.println(message);
    }
}
