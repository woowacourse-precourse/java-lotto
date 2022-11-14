package lotto.exception;

public class InputException {
    private final static String NUMBER_REGEX = "[0-9]+";
    private final static int NUMBER_OUT_OF_RANGE = 1935365522;

    public static int validateIsNumber(String number) {
        try {
            if (!number.matches(NUMBER_REGEX)) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
            }

            return Integer.parseInt(number);
        } catch (Exception exception) {
            if (exception.hashCode() == NUMBER_OUT_OF_RANGE) {
                throw new IllegalArgumentException("[ERROR] 범위를 벗어난 숫자입니다.");
            }
            throw exception;
        }
    }
}
