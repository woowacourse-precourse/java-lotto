package lotto.domain;

import lotto.resource.Constant;
import lotto.view.message.ExceptionMessage;

public class Price {
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
        return purchasePrice % Constant.PRICE_PER_LOTTO.getValue() == 0;
    }

    public Integer getPurchasePrice() {
        return purchasePrice;
    }
}
