package lotto.domain;

import java.util.StringTokenizer;

public class Validation {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final int LOTTO_MONEY = 1000;
    private static final int LOTTO_NUMBER = 6;
    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;

    public static boolean validateInteger(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return true;
    }

    public static boolean isStartWithZero(String input) {
        if (input.charAt(0) == '0') {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return true;
    }

    public static boolean validateAmount(int input) {
        if (input % LOTTO_MONEY != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return true;
    }

    public static boolean validateNumbers(int input) {
        if(input != LOTTO_NUMBER) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return true;
    }

    public static boolean validateRange(int number) {
        if(number < LOTTO_MIN || number > LOTTO_MAX) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return true;
    }

}
