package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.ConsoleMessage;

public class ConsoleView {
    public static int inputPurchasePrice() {
        System.out.println(ConsoleMessage.INPUT_PURCHASE_PRICE.getMessage());
        String input = Console.readLine();
        return stringToInt(input);
    }

    private static int stringToInt(String input) {
        return Integer.parseInt(input);
    }
}
