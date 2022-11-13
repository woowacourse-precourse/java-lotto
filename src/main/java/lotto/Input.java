package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {
    static final int DIVIDENUMBER = 1000;

    public static int userInput() {
        Output.printPurchaseAmount();
        String input = Console.readLine();
        InputException.isValidNumber(input);
        InputException.isValidDivide(Integer.valueOf(input));
        return Integer.valueOf(input) / DIVIDENUMBER;
    }

    public static String winningNumberInput() {
        Output.printWinningNumber();
        String input = Console.readLine();
        InputException.isValidWinningNumberLength(input);
        return input;
    }
}