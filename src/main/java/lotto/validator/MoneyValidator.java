package lotto.validator;

public class MoneyValidator {

    public static void check(int money) {
        checkRange(money);
    }

    private static void checkRange(int money) throws IllegalArgumentException {
        if (isWrongRange(money) || isWrongMoneyUnit(money)) {
            throw new IllegalArgumentException("투입 금액은 1000원이상, 1000단위의 숫자를 입력하세요.");
        }
    }

    private static boolean isWrongMoneyUnit(int money) {
        return money % 1000 > 0;
    }

    private static boolean isWrongRange(int money) {
        return money < 1000;
    }
}
