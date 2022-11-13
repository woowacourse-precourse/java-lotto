package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.valid.InputValidator;

public enum InputView {
    INSTANCE;
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";

    public static int inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        String money = Console.readLine();

        InputValidator.validateMoney(money);

        return Integer.parseInt(money);
    }
}
