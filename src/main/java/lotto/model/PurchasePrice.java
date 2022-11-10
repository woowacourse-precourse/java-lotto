package lotto.model;

import lotto.util.LottoExceptionMessage;

public class PurchasePrice {
    public static final int UNIT = 1000;
    private int price;

    public PurchasePrice(String price) {
        validate(price);
        this.price = Integer.parseInt(price);
    }

    public int getPrice() {
        return price;
    }

    private void validate(String price) {
        if (!hasNumber(price)) {
            throw new IllegalArgumentException(LottoExceptionMessage.PURCHASE_PRICE_IS_NUMBER.getMessage());
        }
        if (!correctUnitOfPrice(Integer.parseInt(price))) {
            throw new IllegalArgumentException(LottoExceptionMessage.PURCHASE_PRICE_UNIT_OF_MONEY.getMessage());
        }
    }

    private boolean correctUnitOfPrice(int price) {
        return price > 0 && price % UNIT == 0;
    }

    private boolean hasNumber(String price) {
        try {
            Integer.parseInt(price);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
