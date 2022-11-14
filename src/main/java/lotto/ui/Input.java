package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String INVALID_MONEY = "[ERROR] 구입 금액은 숫자여야 합니다.";

    public static int readMoney() {
        String input = Console.readLine();
        if (!Validator.isNumber(input)) {
            throw new IllegalArgumentException(INVALID_MONEY);
        }
        return Integer.parseInt(input);
    }
}
