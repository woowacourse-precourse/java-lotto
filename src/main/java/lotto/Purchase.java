package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {
    static final int MIN_MONEY = 1_000;
    private int purchaseMoney;

    public int enterPurchaseMoney() {
        this.purchaseMoney = validatePurchaseMoney(Console.readLine());
        return purchaseMoney / MIN_MONEY;
    }

    public static Integer validatePurchaseMoney(String purchaseMoney) {
        int money = 0;
        try {
            money = Integer.parseInt(purchaseMoney);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionHandler.WRONG_PURCHASE_MONEY);
        }
        if(money % MIN_MONEY != 0)
            throw new IllegalArgumentException(ExceptionHandler.WRONG_PURCHASE_MONEY);
        return money;
    }
    public int getPurchaseMoney() {
        return purchaseMoney;
    }
}
