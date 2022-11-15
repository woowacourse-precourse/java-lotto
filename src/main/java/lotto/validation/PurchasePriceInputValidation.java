package lotto.validation;

import static lotto.validation.ErrorMessage.*;

public class PurchasePriceInputValidation {
    public static final int PRICE_OF_LOTTO = 1000;

    public void validate(String inputPurchasePrice) {
        validateConsistedOnlyOfNumbers(inputPurchasePrice);
        validateDividedByThousand(inputPurchasePrice);
    }

    public void validateConsistedOnlyOfNumbers(String inputPurchasePrice) {
        try {
            Integer.parseInt(inputPurchasePrice);
        } catch (Exception e) {
            throw new IllegalArgumentException(INPUT_PURCHASE_PRICE_IN_INTEGERS.getMessage());
        }
    }

    public void validateDividedByThousand(String inputPurchasePrice) {
        int purchasePrice = Integer.parseInt(inputPurchasePrice);

        if (purchasePrice % PRICE_OF_LOTTO != 0) {
            throw new IllegalArgumentException(PURCHASE_PRICE_DIVIDED_BY_THOUSAND.getMessage());
        }
    }
}
