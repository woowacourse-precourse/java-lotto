package lotto.model;

import lotto.util.Setting;

public class Money {
    private static final String ERROR_UNIT = String.format("[ERROR] 최소 구매 단위는 %s원 입니다.", Setting.MIN_BUY_UNIT);

    private int money;

    public Money(int money) {
        validateUnit(money);
        this.money = money;
    }

    private void validateUnit(int money) {
        if (money % Setting.MIN_BUY_UNIT != 0 || money <= 0) {
            throw new IllegalArgumentException(ERROR_UNIT);
        }
    }

    public int getMoney() {
        return this.money;
    }
}
