package validation;

import static util.validation.ValidationUtil.areInteger;
import static util.validation.ValidationUtil.areValidNumbers;
import static util.validation.ValidationUtil.checkSize;
import static util.validation.ValidationUtil.haveDuplicatedNumbers;
import static util.validation.ValidationUtil.haveUndefinedNumber;
import static util.validation.ValidationUtil.isInteger;
import static util.validation.ValidationUtil.isUnitsOf1000Won;
import static util.validation.ValidationUtil.isWithinValidRange;

import java.util.List;
import lotto.Lotto;

public class Validator {
    public void validateGeneratedNumbers(List<Integer> numbers) {
        if (checkSize(numbers)) {
            throw new IllegalArgumentException();
        }

        if (haveDuplicatedNumbers(numbers)) {
            throw new IllegalArgumentException();
        }
    }

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

    public void validateBonusNumber(String bonusNumber, Lotto winningNumbers) {
        if (!isInteger(bonusNumber)) {
            throw new IllegalArgumentException();
        }

        if (checkSize(bonusNumber)) {
            throw new IllegalArgumentException();
        }

        if (!isWithinValidRange(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
