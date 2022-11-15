package lotto.model;

import lotto.util.LottoExceptionMessage;

public class PurchasePrice {
    public static final int UNIT = 1000;
    private final int purchasePrice;

    public PurchasePrice(String purchasePrice) {
        validate(purchasePrice);
        this.purchasePrice = Integer.parseInt(purchasePrice);
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    private void validate(String purchasePrice) {
        if (!hasNumber(purchasePrice)) {
            throw new IllegalArgumentException(LottoExceptionMessage.PURCHASE_PRICE_IS_NUMBER.getMessage());
        }
        if (!correctUnitOfPrice(Integer.parseInt(purchasePrice))) {
            throw new IllegalArgumentException(LottoExceptionMessage.PURCHASE_PRICE_UNIT_OF_MONEY.getMessage());
        }
    }

    private boolean correctUnitOfPrice(int purchasePrice) {
        return purchasePrice > 0 && purchasePrice % UNIT == 0;
    }

    private boolean hasNumber(String purchasePrice) {
        try {
            Integer.parseInt(purchasePrice);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
