package lotto.view;

import lotto.util.Utils;

public class InputView {
    private static final String PRINT_INPUT_MONEY = "구입금액을 입력해 주세요.";

    public static String inputMoney() {
        System.out.println(PRINT_INPUT_MONEY);
        return Utils.readConsole();
    }
}
