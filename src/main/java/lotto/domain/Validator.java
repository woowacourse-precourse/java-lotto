package lotto.domain;

public class Validator {
    public static void validateAmount(String amount) {
        isNumber(amount);
        isUnitOfThousand(Integer.parseInt(amount));
    }

    private static void isNumber(String amount) {
        if (amount.matches("^[^0-9]*$")) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private static void isUnitOfThousand(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("1,000원 단위로 입력 가능합니다.");
        }
    }

}
