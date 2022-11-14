package lotto.domain;

import lotto.validate.BuyerValidate;

import static lotto.enums.IntEnum.LOTTO_PRICE;

public class Buyer {
    private final int buyPrice;

    public Buyer(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    private void validate(int buyPrice) {
        new BuyerValidate().validate(buyPrice, LOTTO_PRICE.getValue());
    }
}
