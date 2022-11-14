package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {
    static final int MIN_MONEY = 1_000;
    private int purchaseMoney;

    public void enterPurchaseMoney() {
        System.out.println("구입 금액을 입력해주세요.");
        this.purchaseMoney = validatePurchaseMoney(Console.readLine());
    }

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
}
