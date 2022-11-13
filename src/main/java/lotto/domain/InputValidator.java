package lotto.domain;

import static lotto.constant.LottoGameRule.SEPARATOR;

import java.math.BigInteger;

public class InputValidator {
    private static final long MAX_MONEY = 2_147_483_000;
    private static final int SEPARATOR_NUMBER = 5;

    public static boolean isEmpty(String input) {
        return input.isEmpty();
    }

    public static boolean isBlank(String input) {
        return input.isBlank();
    }

    public static boolean isNumber(String input) {
        for (char number : input.toCharArray()) {
            if (!Character.isDigit(number)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isInLimit(String input) {
        BigInteger number = new BigInteger(input);
        if (number.compareTo(BigInteger.valueOf(MAX_MONEY)) > 0) {
            return false;
        }
        return true;
    }

    public static boolean isCorrectSeparator(String input) {
        if (input.contains(SEPARATOR) && countSeparator(input) == SEPARATOR_NUMBER) {
            return false;
        }
        return true;
    }

    private static int countSeparator(String input) {
        return input.length() - input.replace(SEPARATOR, "").length();
    }
}
