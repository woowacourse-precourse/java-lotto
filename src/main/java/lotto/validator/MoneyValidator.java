package lotto.validator;

public class MoneyValidator {

    public static void check(String money){
        checkDigit(money);
        checkRange(Integer.valueOf(money));
    }

    public static void checkDigit(String money) throws IllegalArgumentException {
        final String regex = "^[0-9]+$";
        if (!money.matches(regex)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    public static void checkRange(int money) throws IllegalArgumentException {
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
