package controller;

public class Calculate {
    private static final int PURCHASE_UNIT = 1000;

    public static int calculatePurchaseQuantity(int money) throws IllegalArgumentException {
        if (money % PURCHASE_UNIT == 0) {
            return money / PURCHASE_UNIT;
        }
        throw new IllegalArgumentException("[ERROR] 구입금액이 1000원 단위가 아닙니다.");
    }
}
