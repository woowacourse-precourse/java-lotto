package lotto.domain;

import lotto.enums.IntEnum;
import lotto.validate.BuyerValidate;

import static lotto.enums.IntEnum.*;

public class Buyer {
    private final int buyPrice;

    public Buyer(int buyPrice) {
        validate(buyPrice);
        this.buyPrice = buyPrice;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public int getBuyLottoCount() {
        return buyPrice / IntEnum.LOTTO_PRICE.getValue();
    }

    private void validate(int buyPrice) {
        BuyerValidate buyerValidate = new BuyerValidate();
        buyerValidate.validate(buyPrice, LOTTO_PRICE.getValue());
    }
}
