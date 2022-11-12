package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.regex.Pattern;

public class BuyerView {
    private static final String MESSAGE_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String ERROR_NOT_INT = "[ERROR] 숫자만 입력 가능합니다.";
    private static final String REGEX_INT = "^[0-9]+$";
    private static final int MIN_BUY_UNIT = 1_000;

    public static int inputMoney() {
        System.out.println(MESSAGE_INPUT_MONEY);
        String input = readLine();
        isValidMoneyInput(input);
        return Integer.parseInt(input);
    }

    private static void isValidMoneyInput(String input) {
        if (!isDigit(input) || !isBuyUnit(input)) {
            throw new IllegalArgumentException(ERROR_NOT_INT);
        }
    }

    private static boolean isDigit(String input) {
        return Pattern.matches(REGEX_INT, input);
    }

    private static boolean isBuyUnit(String input) {
        return Integer.parseInt(input) % MIN_BUY_UNIT == 0;
    }
}
