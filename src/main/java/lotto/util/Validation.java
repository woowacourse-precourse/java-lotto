package lotto.util;

public class Validation {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String CONTAIN_NUMBER = "숫자가 아닌 값이 포함되어 있습니다.";
    private static final String LESS_THAN_MINIMUM = "가격이 천원보다 작습니다.";
    private static final String NOT_DIVIDED = "천원으로 나누어 떨어지지 않습니다.";

    public static void isNumber(String input) throws IllegalArgumentException {
        String regExp = "^[0-9]+$";
        if (!input.matches(regExp)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + CONTAIN_NUMBER);
        }
    }

    public static void isHigherThanMinPrice(String input) throws IllegalArgumentException {
        int price = Integer.parseInt(input);
        if (price < 1000) {
            throw new IllegalArgumentException(ERROR_MESSAGE + LESS_THAN_MINIMUM);
        }
    }

    public static void isItDivided(String input) throws IllegalArgumentException {
        int price = Integer.parseInt(input);
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_DIVIDED);
        }
    }
}
