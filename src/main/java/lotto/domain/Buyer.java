package lotto.domain;

import lotto.validate.BuyerValidate;

import static lotto.enums.LottoEum.LOTTO_PRICE;

public class Buyer {
    private final int buyPrice;

    public Buyer(int buyPrice) {
        validate(buyPrice);
        this.buyPrice = buyPrice;
    }

    private void validate(int buyPrice) {
        new BuyerValidate().validate(buyPrice, LOTTO_PRICE.getValue());
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public int getBuyLottoCount() {
        return buyPrice / LOTTO_PRICE.getValue();
    }
}
