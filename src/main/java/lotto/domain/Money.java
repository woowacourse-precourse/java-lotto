package lotto.domain;

import lotto.NumberValidate;

public class Money {
    private Long money;

    public Money(String money) {
        this.money = getPurchaseAmount(money);
    }

    private Long getPurchaseAmount(String money) {
        NumberValidate.digitValidate(money);
        NumberValidate.divideValidate(money);
        return Long.parseLong(money);
    }

    public Long getMoney() {
        return money;
    }
}
