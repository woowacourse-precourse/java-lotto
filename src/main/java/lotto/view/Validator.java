package lotto.view;

public class Validator {

    public static final String PURCHASE_AMOUNT_PATTERN = "^[0-9]+$";

    public static void validatePurchaseAmount(String purchaseAmount) {
        if (!purchaseAmount.matches(PURCHASE_AMOUNT_PATTERN)) {
            throw new IllegalArgumentException();
        }
    }
}
