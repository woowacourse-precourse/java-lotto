package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static int userInput() {
        Output.printPurchaseAmount();
        String input = Console.readLine();
        InputException.isValidNumber(input);
        InputException.isValidDivide(Integer.valueOf(input));
        return Integer.valueOf(input);
    }

    public static String winningNumberInput() {
        Output.printWinningNumber();
        String input = Console.readLine();
        InputException.isValidWinningNumberLength(input);
        return input;
    }

    public static int bonusNumberInput() {
        Output.printBonusNumber();
        String input = Console.readLine();
        InputException.isValidWBonusNumber(input);
        return Integer.valueOf(input);
    }
}