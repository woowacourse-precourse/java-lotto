package lotto.domain;

import static lotto.constant.LottoNumberConstant.LOTTO_PRICE;

import lotto.util.Validator;

public class Money {
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
        return price / LOTTO_PRICE;
    }
}
