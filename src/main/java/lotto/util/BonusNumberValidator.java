package lotto.util;

import lotto.model.Lotto;

public class BonusNumberValidator extends Validator {

    @Override
    public void validate(String input) throws IllegalArgumentException {
        String bonusNumber = removeSpace(input);
        validateNumber(bonusNumber);
        validateInputRange(bonusNumber);
    }

    public void validateDuplicates(String bonusNumber, Lotto lotto) {
        if (lotto.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_DUPLICATED.getMessage());
        }
    }

}
