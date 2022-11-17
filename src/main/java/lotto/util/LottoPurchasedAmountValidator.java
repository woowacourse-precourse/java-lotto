package lotto.util;

import java.util.regex.Pattern;
import lotto.common.InputErrors;
import lotto.common.LottoConstants;

public class LottoPurchasedAmountValidator implements Validator {
    @Override
    public void validate(String userInput) throws IllegalArgumentException {
        validateNotNull(userInput);
        validateNumber(userInput);
        validateRange(userInput);
        validateDivideByLottoUnit(userInput);
    }

    private void validateNotNull(String userInput) {
        if (userInput.isBlank()) {
            throw new IllegalArgumentException(InputErrors.BLANK.getMessage());
        }
    }

    private void validateNumber(String userInput) {
        final String numberRegex = "^([1-9][0-9]*)$";
        if (!Pattern.matches(numberRegex, userInput)) {
            throw new IllegalArgumentException(InputErrors.AMOUNT_NOT_NUMBER.getMessage());
        }

    }

    private void validateRange(String userInput) {
        validateMaxRange(userInput);
        validateMinRange(userInput);
    }

    private void validateMaxRange(String userInput) {
        if (userInput.length() >= LottoConstants.LOTTO_PURCHASED_LIMIT_DIGIT // 6자리 이상이면서 100_000이 아닌 경우 예외
                && !userInput.equals(String.valueOf(LottoConstants.LOTTO_PURCHASED_LIMIT))) {
            throw new IllegalArgumentException(InputErrors.AMOUNT_OVER_LIMIT.getMessage());
        }
    }

    private void validateMinRange(String userInput) {
        if (Integer.parseInt(userInput) < LottoConstants.AMOUNT_PER_LOTTO) {
            throw new IllegalArgumentException(InputErrors.AMOUNT_UNDER_MINIMUM.getMessage());
        }
    }

    private void validateDivideByLottoUnit(String userInput) {
        if (Integer.parseInt(userInput) % LottoConstants.AMOUNT_PER_LOTTO != 0) {
            throw new IllegalArgumentException(InputErrors.AMOUNT_NOT_DIVIDABLE.getMessage());
        }
    }
}
