package lotto.validator;

public class MoneyValidator {
    public static final String INPUT_ONLY_NUMBER = "[ERROR] 숫자만 입력해주세요.";
    public static final String CAN_DIVIDE_1000 = "[ERROR] 구입 금액은 1,000으로 나누어떨어져야 합니다.";
    public static final String OVER_THAN_1000 = "[ERROR] 구입 금액은 1,000보다 커야 합니다.";

    public static void validateMoney(String input) {
        isNumber(input);
        isMultiplesOf1000(input);
        isOverThan1000(input);
    }

    public static void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ONLY_NUMBER);
        }
    }

    public static void isMultiplesOf1000(String input) {
        int num = Integer.parseInt(input);
        if (num % 1000 != 0) {
            throw new IllegalArgumentException(CAN_DIVIDE_1000);
        }
    }

    public static void isOverThan1000(String input) {
        int num = Integer.parseInt(input);
        if (num < 1000) {
            throw new IllegalArgumentException(OVER_THAN_1000);
        }
    }
}
