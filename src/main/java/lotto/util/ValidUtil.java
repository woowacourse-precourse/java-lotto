package lotto.util;


import static lotto.constants.AmountCode.AMOUNTS_UNIT;

public class ValidUtil {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static String validInputAmounts(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 숫자를 입력해야 합니다.");
        }
        return input;
    }

    public static int validAmountUnit(int amount) {
        if (amount % AMOUNTS_UNIT != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE +
                    " 로또 금액은 1000원 단위이어야 합니다.");
        }
        return amount;
    }

}
