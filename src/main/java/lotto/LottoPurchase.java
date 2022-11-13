package lotto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LottoPurchase {
    private static final String REGEX = "(^[1-45]*$)";
    private static final int MIN_MONEY = 1000;
    private static final int ZERO =  0;
    private static final String MONEY_DIVIDED_ERROR = "[ERROR] 구매한 금액은 1000원 단위이여야 합니다.";
    private static final String MONEY_MINIMUM_ERROR = "[ERROR] 구매한 금액은 1000원 이상이여야 합니다.";
    private static final String MONEY_NUMBER_ERROR = "[ERROR] 구매한 금액은 숫자입니다.";
    private final String money;

    public LottoPurchase(String money) {
        validatePurchase(money);
        this.money = money;
    }

    private void validatePurchase(String money) {
        validateDivide(money);
        validateMinimum(money);
        validateNumber(money);
    }

    private void validateDivide(String money) {
        if (parse(money) % MIN_MONEY != ZERO) {
            throw new IllegalArgumentException(MONEY_DIVIDED_ERROR.toString());
        }
    }

    private void validateMinimum(String money) {
        if (parse(money) < MIN_MONEY) {
            throw new IllegalArgumentException(MONEY_MINIMUM_ERROR.toString());
        }
    }

    private void validateNumber(String money) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(money);
        if (!matcher.find()) {
            throw new IllegalArgumentException(MONEY_NUMBER_ERROR.toString());
        }
    }
    private int parse(String money) {
        return Integer.parseInt(money);
    }

}
