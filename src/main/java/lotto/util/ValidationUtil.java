package lotto.util;

import java.util.List;

public class ValidationUtil {

    final static int MIN_UNIT_OF_AMOUNT = 1000;
    final static int LENGTH_OF_WINNING_NUM_LIST = 6;
    final static int START_NUM = 1;
    final static int END_NUM = 45;

    public static boolean validateEmpty(String input) {
        return input.isEmpty();
    }

    public static boolean validateIsDigit(String input) {
        for (int i=0; i<input.length(); i++) {
            char inputChar = input.charAt(i);
            if (!Character.isDigit(inputChar)) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateMinNumber(int input) {

        return input >= 1000;
    }

    public static boolean validateRemainder(int input) {
        return input % MIN_UNIT_OF_AMOUNT == 0;
    }

    public static boolean validateIsDigitAndComma(String input) {
        for (int i=0; i<input.length(); i++) {
            char winningNum = input.charAt(i);
            if (!Character.isDigit(winningNum) && winningNum!=',') {
                return false;
            }
        }
        return true;
    }

    public static boolean invalidComma(String input) {
        if (input.startsWith(",") || input.endsWith(",")
                || input.contains(",,")) {
            return false;
        }
        return true;
    }

    public static boolean validateIsInRange(int input) {
        return input>=1 && input<=45;
    }
}
