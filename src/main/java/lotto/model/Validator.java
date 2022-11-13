package lotto.model;

public class Validator {
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String INPUT_VALUE_IS_NOT_NUMBER = "입력은 숫자 형식이어야 합니다.";

    public int convertStringIntoInt(String stringNumber) {
        int intNumber;
        try {
            intNumber = Integer.parseInt(stringNumber);
            return intNumber;
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_PREFIX + INPUT_VALUE_IS_NOT_NUMBER);
        }
    }
}
