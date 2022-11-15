package lotto.domain;

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

    public float clacEarningRate(Integer totEarning) {
        float earningRate = (float) totEarning / purchaseMoney * 100 * 10;
        earningRate = (float) Math.round(earningRate) / 10;
        return earningRate;
    }
    public int getPurchaseMoney() {
        return purchaseMoney;
    }

    public void setPurchaseMoney(int purchaseMoney) {
        this.purchaseMoney = purchaseMoney;
    }
}
