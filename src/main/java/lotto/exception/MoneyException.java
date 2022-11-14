package lotto.exception;

import java.util.regex.Pattern;

public class MoneyException {
    public static final String INVALID_MONEY_TYPE = "[ERROR] 금액은 숫자여야 합니다.";
    private static final Pattern INPUT_PATTERN = Pattern.compile("\\d");
    public static final String MONEY_MUST_NOT_NEGATIVE = "[ERROR] 금액은 음수일 수 없습니다.";
    public static final String MONEY_MUST_MULTIPLE_OF_THOUSAND = "[ERROR] 금액은 1,000원 단위로 나누어 떨어져야 합니다.";

    public static void isValidMoneyType(String money) {
        if (!INPUT_PATTERN.matcher(money).matches()) {
            throw new IllegalArgumentException(INVALID_MONEY_TYPE);
        }
    }

    public static void isPositive(String money) {
        if (Integer.parseInt(money) < 0) {
            throw new IllegalArgumentException(MONEY_MUST_NOT_NEGATIVE);
        }
    }

    public static void isDivideByThousand(String money) {
        if (Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException(MONEY_MUST_MULTIPLE_OF_THOUSAND);
        }
    }
}
