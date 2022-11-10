package model;

import util.exception.Valid;
import util.message.ErrorMessage;

public class Purchase {
    private static final int PURCHASE_MONEY_UNIT = 1000;

    private int money;

    public Purchase(int money) {
        this.money = money;
    }

    public static boolean validate(String money){
        if (!Valid.isDigit(money)) {
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
}
