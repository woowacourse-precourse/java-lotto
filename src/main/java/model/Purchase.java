package model;

import util.message.ErrorMessage;
import view.PrintView;

public class Purchase {
    private static final int PURCHASE_MONEY_UNIT = 1000;

    private int money;

    public Purchase(int money) {
        validate(money);
        this.money = money;
    }

    private boolean validate(int money){
        if (!isMoneyOverThousand(money)) {
            throw new IllegalArgumentException(ErrorMessage.OVER_THOUSAND_MONEY);
        }
        if (!isMoneyThousandUnit(money)) {
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

    public int getMoney() {
        return money;
    }
}
