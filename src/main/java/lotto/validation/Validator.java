package lotto.validation;

public class Validator {

    private static final String FIRST_NUMBER_ZERO = "첫 자리는 0을 입력할 수 없습니다.";
    private static final String PATTERN = "^[0-9]+$";
    private static final String INPUT_NUMBER = "숫자를 입력해주세요.";
    private static final String INPUT_THOUSAND_UNIT = "1000원 단위로 입력해주세요.";
    private static final int THOUSAND = 1000;
    private static final int ZERO = 0;

    public static void validateInputMoney(String money) {
        isFirstNumberZero(money);
        isCorrectMoneyPattern(money);
    }

    private static void isFirstNumberZero(String money) {
        if (money.charAt(0) == '0') {
            throw new IllegalArgumentException(FIRST_NUMBER_ZERO);
        }
    }

    private static void isCorrectMoneyPattern(String money) {
        if (!money.matches(PATTERN)) {
            throw new IllegalArgumentException(INPUT_NUMBER);
        }
    }

    public static void isDividedByThousand(int money) {
        if (money % THOUSAND != ZERO) {
            throw new IllegalArgumentException(INPUT_THOUSAND_UNIT);
        }
    }
}
