package lotto.view;

import lotto.util.Constants;
import lotto.util.Utils;

public class InputView {
    public static String inputMoney() {
        System.out.println(Constants.PRINT_INPUT_MONEY);
        return Utils.readConsole();
    }

    public static String inputWinningNumbers() {
        System.out.println(Constants.PRINT_INPUT_WINNING_NUMBERS);
        return Utils.readConsole();
    }

    public static String inputWinningBonus() {
        System.out.println(Constants.PRINT_INPUT_WINNING_BONUS);
        return Utils.readConsole();
    }
}