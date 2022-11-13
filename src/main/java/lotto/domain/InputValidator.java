package lotto.domain;

import java.math.BigInteger;

public class InputValidator {
    private static final long MAX_MONEY = 2_147_483_000;

    public static boolean isEmpty(String input) {
        return input.isEmpty();
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
}
