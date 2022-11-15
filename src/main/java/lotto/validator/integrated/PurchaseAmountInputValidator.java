package lotto.validator.integrated;

import lotto.validator.InputValidator;
import lotto.validator.NumericValidator;
import lotto.validator.RangeValidator;

public interface PurchaseAmountInputValidator extends NumericValidator, RangeValidator<Long>,
    InputValidator<String> {

    boolean isDividedBySmallestUnit(Long target);
}
