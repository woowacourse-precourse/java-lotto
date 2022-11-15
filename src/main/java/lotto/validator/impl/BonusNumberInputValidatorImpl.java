package lotto.validator.impl;

import lotto.type.ErrorCode;
import lotto.type.LottoInformation;
import lotto.validator.integrated.BonusNumberInputValidator;

public class BonusNumberInputValidatorImpl implements BonusNumberInputValidator {

    @Override
    public void validate(final String target) throws IllegalArgumentException {
        if (!isNumeric(target)) {
            throw new IllegalArgumentException(ErrorCode.NON_NUMERIC_VALUE.getMessage());
        }
        if (!isInRange(Integer.parseInt(target), LottoInformation.START.value(),
            LottoInformation.END.value())) {
            throw new IllegalArgumentException(ErrorCode.TOO_BIG_OR_TOO_SMALL_VALUE.getMessage());
        }
    }
}
