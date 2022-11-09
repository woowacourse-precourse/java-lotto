package util.exception;

import util.message.ErrorMessage;

public class Valid {
    private static final int PURCHASE_MONEY_UNIT = 1000;

    public static void purchaseMoney(int money){
        if (!isMoneyOverThousand(money)) {
            throw new IllegalArgumentException(ErrorMessage.OVER_THOUSAND_MONEY);
        }
        if (!isMoneyThousandUnit(money)) {
            throw new IllegalArgumentException(ErrorMessage.UNIT_THOUSAND_MONEY);
        }
    }

    public static boolean isMoneyThousandUnit(int money) {
        if (money % PURCHASE_MONEY_UNIT != 0) {
            return false;
        }
        return true;
    }

    public static boolean isMoneyOverThousand(int money){
        if (money < PURCHASE_MONEY_UNIT) {
            return false;
        }
        return true;
    }
}
