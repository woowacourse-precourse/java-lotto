package lotto.input.validation;

import lotto.input.validation.code.TotalPriceValidationCode;

public class TotalPriceValidator {

    public TotalPriceValidationCode getUserTotalPriceInputValidationCode(String userInput) {
        if (!isUserInputValidNumberFormat(userInput) || !isFirstLetterBetweenOneAndNine(userInput)) {
            return TotalPriceValidationCode.INVALID_NUMBER_FORMAT;
        }

        int value = Integer.parseInt(userInput);
        if (!isValueMoreThanOrEqualToOneThousand(value) || !isValueMultipleOfOneThousand(value)) {
            return TotalPriceValidationCode.INVALID_NUMBER;
        }

        return TotalPriceValidationCode.VALID_NUMBER;
    }

    public boolean isUserInputValidNumberFormat(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException exception) {
            return false;
        }
        return true;
    }

    public boolean isFirstLetterBetweenOneAndNine(String userInput) {
        char firstLetter = userInput.charAt(0);
        return firstLetter >= '1' && firstLetter <= '9';
    }

    public boolean isValueMoreThanOrEqualToOneThousand(int value) {
        return value >= 1000;
    }

    public boolean isValueMultipleOfOneThousand(int value) {
        return (value / 1000 >= 1) && (value % 1000 == 0);
    }
}
