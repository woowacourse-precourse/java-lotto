package lotto;

public class InputValidator {

    static final int MIN_MONEY = 1_000;

    public static Integer validatePurchaseMoney(String purchaseMoney) {
        int money = 0;
        try {
            money = Integer.parseInt(purchaseMoney);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionHandler.WORNG_PURCHASE_MONEY);
        }
        if(money % MIN_MONEY != 0)
            throw new IllegalArgumentException(ExceptionHandler.WORNG_PURCHASE_MONEY);
        return money;
    }

    public static boolean validateSixNumber() {
        return false;
    }

    public static boolean validateBonusNumber() {
        return false;
    }

}
