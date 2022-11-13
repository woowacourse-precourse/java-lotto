package lotto.domain;

public class Validator {
    public static void validateAmount(String amount) {
        isNumber(amount);
    }

    private static void isNumber(String amount) {
        if (amount.matches("^[^0-9]*$")) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }
}
