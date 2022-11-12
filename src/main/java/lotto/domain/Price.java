package lotto.domain;

import lotto.view.message.ExceptionMessage;

public class Price {
    private static final int MIN_PURCHASE_PRICE = 1000;

    private final Integer purchasePrice;

    public Price(Integer purchasePrice) {
        validate(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    private void validate(Integer purchasePrice) {
        if (!isPriceInUnitsOfOneThousandWon(purchasePrice)) {
            System.out.println(ExceptionMessage.NON_UNITS_OF_ONE_THOUSAND_WON.getMessage());
            throw new IllegalArgumentException();
        }

        if (!hasMoney(purchasePrice)) {
            System.out.println(ExceptionMessage.NO_MONEY.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private boolean hasMoney(Integer purchasePrice) {
        return purchasePrice != 0;
    }

    private boolean isPriceInUnitsOfOneThousandWon(Integer purchasePrice) {
        return purchasePrice % MIN_PURCHASE_PRICE == 0;
    }

    public Integer getPurchasePrice() {
        return purchasePrice;
    }
}
