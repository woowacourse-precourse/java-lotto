package lotto.domain;

import lotto.util.Validator;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private int price;

    public Money(int price) {
        validate(price);
        this.price = price;
    }

    public Money(String money) {
        Validator validator = new Validator();
        validator.isNumber(money);
        this.price = Integer.parseInt(money);
    }

    private void validate(int price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getPrice() {
        return price;
    }

    public int lottoCount() {
        return price / 1000;
    }
}
