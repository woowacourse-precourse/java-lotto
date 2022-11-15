package lotto.validator;

import static lotto.util.Const.*;

public class InputValidator {

    private static final long MAX_INPUT_MONEY =  (Long.MAX_VALUE / LOTTO_PRICE_UNIT) * LOTTO_PRICE_UNIT;

    public static void checkMoney(String money) throws IllegalArgumentException {
        if (isNotDigit(money)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }

        if (isOverMax(money)) {
            throw new IllegalArgumentException("입력할 수 있는 금액의 최대값을 넘었습니다.");
        }
    }

    public static void checkBonusNumber(String number) {
        if (isNotDigit(number)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private static boolean isNotDigit(String number) {
        final String regex = "^[0-9]+$";
        return !number.matches(regex);
    }

    private static boolean isOverMax(String money) {
        return Long.parseLong(money) > MAX_INPUT_MONEY;
    }
}
