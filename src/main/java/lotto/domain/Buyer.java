package lotto.domain;

import lotto.validate.BuyerValidate;

public class Buyer {
    private final int buyPrice;
    private static final int LOTTO_PRICE = 1000;

    public Buyer(int buyPrice) {
        validate(buyPrice);
        this.buyPrice = buyPrice;
    }

    public int getBuyLottoCount() {
        return buyPrice / LOTTO_PRICE;
    }

    private void validate(int buyPrice) {
        BuyerValidate buyerValidate = new BuyerValidate();
        buyerValidate.validate(buyPrice, LOTTO_PRICE);
    }
}
