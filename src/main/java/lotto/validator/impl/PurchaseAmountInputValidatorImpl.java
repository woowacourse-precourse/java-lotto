package lotto.validator.impl;

import lotto.type.ErrorCode;
import lotto.type.LottoInformation;
import lotto.validator.integrated.PurchaseAmountInputValidator;

public class PurchaseAmountInputValidatorImpl implements PurchaseAmountInputValidator {

    @Override
    public void validate(final String target) throws IllegalArgumentException {
        if (!isNumeric(target)) {
            throw new IllegalArgumentException(ErrorCode.NON_NUMERIC_VALUE.getMessage());
        }
        final Long targetNumber = parseTargetToLong(target);
        if (targetNumber == null || !isInRange(targetNumber, 1L, Long.MAX_VALUE)) {
            throw new IllegalArgumentException(ErrorCode.TOO_BIG_OR_TOO_SMALL_VALUE.getMessage());
        }
        if (!isDividedBySmallestUnit(targetNumber)) {
            throw new IllegalArgumentException(
                ErrorCode.COULD_NOT_DIVIDE_BY_SMALLEST_UNIT.getMessage());
        }
    }

    @Override
    public boolean isDividedBySmallestUnit(final Long target) {
        return target % LottoInformation.SMALLEST_UNIT.value() == 0;
    }

    private static Long parseTargetToLong(final String target) {
        long targetNumber;
        try {
            targetNumber = Long.parseLong(target);
        } catch (NumberFormatException e) {
            return null;
        }
        return targetNumber;
    }
}
