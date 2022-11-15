package lotto.validator.integrated;

import lotto.validator.InputValidator;
import lotto.validator.NumericValidator;
import lotto.validator.RangeValidator;

public interface BonusNumberInputValidator extends NumericValidator, RangeValidator<Integer>,
    InputValidator<String> {

}
