package util.exception;

public class Valid {
    private static final int PURCHASE_MONEY_UNIT = 1000;

    public static void purchaseMoney(int money){
        if (!isMoneyOverThousand(money)||!isMoneyThousandUnit(money)) {
            throw new IllegalArgumentException();
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
