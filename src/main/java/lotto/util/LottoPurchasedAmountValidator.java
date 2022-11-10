package lotto.util;

import java.util.regex.Pattern;
import lotto.common.InputErrors;

public class LottoPurchasedAmountValidator implements Validator {

    private static final int LOTTO_PURCHASED_LIMIT = 100_000;
    private static final int AMOUNT_PER_LOTTO = 1_000;
    private static final int LOTTO_PURCHASED_LIMIT_DIGIT = 6;

    @Override
    public void validate(String userInput) throws IllegalArgumentException {
        validateNotNull(userInput);
        validateNumber(userInput);
        validateRange(userInput);
        validateDivideByLottoUnit(userInput);
    }

    private boolean validateNotNull(String userInput) {
        if (!userInput.isBlank()) {
            return true;
        }

        throw new IllegalArgumentException(InputErrors.BLANK.getMessage());
    }

    private boolean validateNumber(String userInput) {
        final String numberRegex = "^([1-9][0-9]*)$";
        if (Pattern.matches(numberRegex, userInput)) {
            return true;
        }

        throw new IllegalArgumentException(InputErrors.AMOUNT_NOT_NUMBER.getMessage());
    }

    private boolean validateRange(String userInput) {
        if (isLessOrEqualThanLimit(userInput)
                && isGreaterAndEqualThanLottoUnit(userInput)) {
            return true;
        }

        return false;
    }

    private boolean isLessOrEqualThanLimit(String userInput) {
        if (userInput.length() < LOTTO_PURCHASED_LIMIT_DIGIT
                || userInput.equals(String.valueOf(LOTTO_PURCHASED_LIMIT))) {
            return true;
        }

        throw new IllegalArgumentException(InputErrors.AMOUNT_OVER_LIMIT.getMessage());
    }

    private boolean isGreaterAndEqualThanLottoUnit(String userInput) {
        if (Integer.parseInt(userInput) >= AMOUNT_PER_LOTTO) {
            return true;
        }

        throw new IllegalArgumentException(InputErrors.AMOUNT_UNDER_MINIMUM.getMessage());
    }

    private boolean validateDivideByLottoUnit(String userInput) {
        if (Integer.parseInt(userInput) % AMOUNT_PER_LOTTO == 0) {
            return true;
        }

        throw new IllegalArgumentException(InputErrors.AMOUNT_NOT_DIVIDABLE.getMessage());
    }
}
