package lotto.validator.integrated;

import java.util.List;
import lotto.validator.DuplicateValidator;
import lotto.validator.InputValidator;
import lotto.validator.NumericValidator;
import lotto.validator.RangeValidator;
import lotto.validator.SizeValidator;

public interface WinningNumberInputValidator extends NumericValidator, SizeValidator<List<Integer>>,
    RangeValidator<Integer>, DuplicateValidator<Integer>, InputValidator<List<String>> {

}
