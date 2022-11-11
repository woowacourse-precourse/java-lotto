package lotto;

import camp.nextstep.edu.missionutils.Console;

import static lotto.Constants.*;

public class Input {
    private final static String ONLY_NUMBER = "^\\d+$";

    public static final String submit(String message) {
        System.out.println(message);
        String inputValue = Console.readLine();
        System.out.println();
        return inputValue;
    }

    public static void validateIfNumeric(String input) {
        boolean isNumber = input.matches(ONLY_NUMBER);
        if (!isNumber) {
            throw new IllegalArgumentException(ERROR_TITLE + NON_NUMERIC);
        }
    }

    public static void validateIfInThousands(String input) {
        String lastThreeDigits = input.substring(input.length() - 3);
        if (!lastThreeDigits.equals("000")) {
            throw new IllegalArgumentException(ERROR_TITLE + NOT_IN_THOUSANDS);
        }
    }
}
