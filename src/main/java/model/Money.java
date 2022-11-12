package model;

import constant.Config;

import static constant.Config.PRICE;

public class Money {
    private static final String PRICE_ERROR = String.format("%s 구입금액은 %,d원으로 나누어 떨어져야 합니다.", Config.ERROR, PRICE);

    private final int money;

    public Money(int money) {
        validatePrice(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    private static void validatePrice(int money) {
        if (money % PRICE != 0 || money < PRICE) {
            throw new IllegalArgumentException(PRICE_ERROR);
        }
    }
}
