package lotto.util;

import java.util.regex.Pattern;
import lotto.common.InputErrors;
import lotto.common.LottoConstants;

public class BonusNumberValidator implements Validator {
    @Override
    public void validate(String userInput) throws IllegalArgumentException {
        validateNotNull(userInput);
        validateNumber(userInput);
        validateRange(userInput);
    }

    private void validateNotNull(String userInput) {
        if (userInput.isBlank()) {
            throw new IllegalArgumentException(InputErrors.BLANK.getMessage());
        }
    }

    private void validateNumber(String userInput) {
        final String numberRegex = "^([0-9]{0,2})$";
        if (!Pattern.matches(numberRegex, userInput)) {
            throw new IllegalArgumentException(InputErrors.BONUS_NUMBER_NOT_NUMBER.getMessage());
        }
    }

    private void validateRange(String userInput) {
        int number = Integer.parseInt(userInput);
        if (number < LottoConstants.LOTTO_NUMBER_MIN_RANGE ||
                number > LottoConstants.LOTTO_NUMBER_MAX_RANGE) {
            throw new IllegalArgumentException(InputErrors.BONUS_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }


}
