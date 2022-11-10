package lotto;

import java.util.List;



public class InputValidator {
    private static final String NUMBER_REGEX = "^[0-9]";
    private static final int LOTTO_PRICE = 1000;


    public static boolean isInvalidMoneyForm(String input) {
        if (!input.matches(NUMBER_REGEX)) {
            return true;
        }

        return false;
    }

    public static boolean isInvalidSeparator(List<String> splitedInput) {
        for (String eachInput : splitedInput) {
            if (!eachInput.matches(NUMBER_REGEX)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isInvalidMoneyUnit(int money) {
        if (money % LOTTO_PRICE == 0) {
            return true;
        }

        return false;
    }
}
