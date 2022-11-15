package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LottoPurchase {
    private static final String REGEX = "(^[0-9]*$)";
    private static final int MIN_MONEY = 1000;
    private static final int ZERO =  0;
    private static final double DECIMAL_POINT = 1.0;
    private static  final int PERCENT = 100;
    private static final String MONEY_NUMBER_ERROR = "[ERROR] 구매한 금액은 숫자이여야 합니다.";
    private static final String MONEY_DIVIDED_ERROR = "[ERROR] 구매한 금액은 1000원 단위이여야 합니다.";
    private static final String MONEY_MINIMUM_ERROR = "[ERROR] 구매한 금액은 1000원 이상이여야 합니다.";
    private int money;
    public LottoPurchase(String money) {
        validatePurchase(money);
        this.money = parse(money);
    }
    public int calculateTicketCount() {
        return money / MIN_MONEY;
    }
    public double calculateProfit(long sum) {
        return DECIMAL_POINT * PERCENT * sum / money;
    }
    private void validatePurchase(String money) {
        validateNumber(money);
        validateDivide(money);
        validateMinimum(money);
    }

    private void validateNumber(String money) {
        if (!Pattern.matches(REGEX,money)) {
            throw new IllegalArgumentException(MONEY_NUMBER_ERROR.toString());
        }
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

    private int parse(String money) {
        return Integer.parseInt(money);
    }

}
