package lotto.Validator;

public class MoneyValidator {
    public static void validateMoney(String input) {
        isNumber(input);
        isMultiplesOf1000(input);
        isOverThan1000(input);
    }

    public static void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 자연수만 입력해주세요");
        }
    }

    public static void isMultiplesOf1000(String input) {
        int num = Integer.parseInt(input);
        if (num % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원으로 나누어떨어져야 합니다.");
        }
    }

    public static void isOverThan1000(String input) {
        int num = Integer.parseInt(input);
        if (num < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원보다 커야 합니다.");
        }
    }
}
