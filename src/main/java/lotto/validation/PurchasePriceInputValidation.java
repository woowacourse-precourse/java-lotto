package lotto.validation;

import static lotto.validation.ErrorMessage.*;

public class PurchasePriceInputValidation {
    public static final int PRICE_OF_LOTTO = 1000;

    public void validateConsistedOnlyOfNumbers(String inputPurchasePrice) {
        try {
            Integer.parseInt(inputPurchasePrice);
        } catch (Exception e) {
            throw new IllegalArgumentException(INPUT_PURCHASE_PRICE_IN_INTEGERS.getMessage());
        }
    }

    public void validateDividedByThousand(int purchasePrice) {
        if (purchasePrice % PRICE_OF_LOTTO != 0) {
            throw new IllegalArgumentException(PURCHASE_PRICE_DIVIDED_BY_THOUSAND.getMessage());
        }
    }
}
