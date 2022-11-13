package lotto.validator;

public class InputValidator {

    public static void checkDigit(String money) throws IllegalArgumentException {
        final String regex = "^[0-9]+$";
        if (!money.matches(regex)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }
}
