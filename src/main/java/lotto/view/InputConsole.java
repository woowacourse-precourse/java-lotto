package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Validator;

import static lotto.view.ConsoleMessage.TYPE_PURCHASE_PRICE;

public class InputConsole {
    public InputConsole() {

    }

    public static String readLine() {
        return Console.readLine().strip();
    }

    public static int askPurchasePrice() {
        System.out.println(TYPE_PURCHASE_PRICE);
        String input = readLine();
        Validator.isValidPurchasePrice(input);
        return Integer.parseInt(input);
    }
}
