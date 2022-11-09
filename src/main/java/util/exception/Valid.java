package util.exception;

import java.util.regex.Pattern;
import util.message.ErrorMessage;

public class Valid {
    private static final int PURCHASE_MONEY_UNIT = 1000;
    private static final String NUMBER_REGEX = "^[0-9]*$";

    public static boolean purchaseMoney(String money){
        if (!isDigit(money)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_STRING_MONEY);
        }
        if (!isMoneyOverThousand(Integer.parseInt(money))) {
            throw new IllegalArgumentException(ErrorMessage.OVER_THOUSAND_MONEY);
        }
        if (!isMoneyThousandUnit(Integer.parseInt(money))) {
            throw new IllegalArgumentException(ErrorMessage.UNIT_THOUSAND_MONEY);
        }
        return true;
    }

    private static boolean isMoneyThousandUnit(int money) {
        if (money % PURCHASE_MONEY_UNIT != 0) {
            return false;
        }
        return true;
    }

    private static boolean isMoneyOverThousand(int money){
        if (money < PURCHASE_MONEY_UNIT) {
            return false;
        }
        return true;
    }

    private static boolean isDigit(String input) {
        if (!Pattern.matches(NUMBER_REGEX, input)) {
            return false;
        }
        return true;
    }
}
