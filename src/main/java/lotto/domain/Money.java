package lotto.domain;

import lotto.constant.Constant;
import lotto.utils.Validation;

public class Money {

    private final int money;

    public Money(String money) {
        Validation.validateCheckNumeric(money, Constant.SPLIT_FOR_MONEY);
        Validation.validateFirstNumberIsNotZero(money);
        Validation.checkThousandMoney(money);
        this.money = Integer.parseInt(money);
    }

    public int getNumberOfPurchase() {
        return money / Constant.LOTTO_PRICE;
    }
}
