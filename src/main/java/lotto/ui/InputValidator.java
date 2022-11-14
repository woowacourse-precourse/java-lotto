package lotto.ui;

import java.util.regex.Pattern;

public class InputValidator {
    private static final String INPUT_MONEY_PATTERN = "^[1-9]+[0-9]{3,8}+$";

    public static void checkInputMoney(String inputMoneyRaw) {
        boolean isMatch = Pattern.matches(INPUT_MONEY_PATTERN, inputMoneyRaw);
        if (isMatch) {
            return;
        }
        throw new IllegalArgumentException(
                "[ERROR] 1000의 배수를 입력하세요. 단, 1000000000 미만의 수만 입력해주세요. (ex: 2000, 12345000)"
        );
    }
}
