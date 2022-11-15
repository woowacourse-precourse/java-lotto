package lotto.model;

import static lotto.model.Error.PRICE_UNIT_ERROR;

public class LottoPrice {

    private final int LOTTO_PRICE = 1000;
    private final int price;
    private final int amount;

    public LottoPrice(int price) {
        checkPrice(price);
        this.price = price;
        this.amount = price / LOTTO_PRICE;
    }

    public void checkPrice(int price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PRICE_UNIT_ERROR.getMessage());
        }
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }
}
