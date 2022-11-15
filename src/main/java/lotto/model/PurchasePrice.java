package lotto.model;

import java.math.BigInteger;
import lotto.util.LottoExceptionMessage;

public class PurchasePrice {
    public static final int UNIT = 1000;
    private final int purchasePrice;

    public PurchasePrice(String purchasePrice) {
        validate(purchasePrice);
        this.purchasePrice = Integer.parseInt(purchasePrice);
    }

    private void validate(String purchasePrice) {
        if (!hasNumber(purchasePrice)) {
            throw new IllegalArgumentException(LottoExceptionMessage.PURCHASE_PRICE_IS_NUMBER.getMessage());
        }
        if (!acceptsNumberRange(purchasePrice)) {
            throw new IllegalArgumentException(LottoExceptionMessage.PURCHASE_PRICE_OVER_MAX_NUMBER.getMessage());
        }
        if (!correctUnitOfPrice(Integer.parseInt(purchasePrice))) {
            throw new IllegalArgumentException(LottoExceptionMessage.PURCHASE_PRICE_UNIT_OF_MONEY.getMessage());
        }
    }

    private boolean hasNumber(String purchasePrice) {
        try {
            new BigInteger(purchasePrice);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean acceptsNumberRange(String purchasePrice) {
        return BigInteger.valueOf(Integer.MAX_VALUE).compareTo(new BigInteger(purchasePrice)) > 0;
    }

    private boolean correctUnitOfPrice(int purchasePrice) {
        return purchasePrice > 0 && purchasePrice % UNIT == 0;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }
}
