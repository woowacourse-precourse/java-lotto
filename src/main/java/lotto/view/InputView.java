package lotto.view;

import lotto.util.Constants;
import lotto.util.Utils;

public class InputView {
    public static String inputMoney() {
        System.out.println(Constants.PRINT_INPUT_MONEY);
        return Utils.readConsole();
    }
}