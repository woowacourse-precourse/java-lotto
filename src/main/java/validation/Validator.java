package validation;

import static util.validation.ValidationUtil.areInteger;
import static util.validation.ValidationUtil.areValidNumbers;
import static util.validation.ValidationUtil.haveUndefinedNumber;
import static util.validation.ValidationUtil.isInteger;
import static util.validation.ValidationUtil.isUnitsOf1000Won;

import java.util.List;

public class Validator {
    public void validatePurchasePrice(String purchasePrice) {
        if (!isInteger(purchasePrice)) {
            throw new IllegalArgumentException();
        }

        if (!isUnitsOf1000Won(purchasePrice)) {
            throw new IllegalArgumentException();
        }
    }

    public void validateWinningNumbers(List<String> numbers) {
        if (haveUndefinedNumber(numbers)) {
            throw new IllegalArgumentException();
        }

        if (!areInteger(numbers)) {
            throw new IllegalArgumentException();
        }

        if (!areValidNumbers(numbers)) {
            throw new IllegalArgumentException();
        }
    }
}
