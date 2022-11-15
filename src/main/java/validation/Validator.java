package validation;

import static util.validation.ValidationUtil.isInteger;
import static util.validation.ValidationUtil.isUnitsOf1000Won;

public class Validator {
    public void validatePurchasePrice(String purchasePrice) {
        if (!isInteger(purchasePrice)) {
            throw new IllegalArgumentException();
        }

        if (!isUnitsOf1000Won(purchasePrice)) {
            throw new IllegalArgumentException();
        }
    }
}
