package lotto.domain;

import lotto.util.Validator;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private int price;

    public Money(String money) {
        Validator validator = new Validator();
        validator.validateMoney(money);
        this.price = Integer.parseInt(money);
    }

    public int getPrice() {
        return price;
    }

    public int lottoCount() {
        return price / 1000;
    }
}
