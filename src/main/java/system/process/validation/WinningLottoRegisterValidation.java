package system.process.validation;

import constants.LottoConstant;
import system.process.exception.IllegalArgument;
import utils.IsCollection;

public class WinningLottoRegisterValidation {
    public static void validateLottoNumbersInput(String inputNumbers) {
        if (inputNumbers.length() > LottoConstant.MAX_INPUT_NUMBERS_LENGTH) {
            IllegalArgument.handleException(IllegalArgument.OUT_OF_NUMBERS_LENGTH.getMessage());
        }
    }

    public static void validateCommaIndex(String numbersInput, int commaIndex) {
        if (commaIndex < LottoConstant.LEAST_COMMA_POSITION) {
            IllegalArgument.handleException(IllegalArgument.WRONG_NUMBERS_INPUT.getMessage());
        }
        if (Character.isDigit(numbersInput.charAt(commaIndex - 1))) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.WRONG_NUMBERS_INPUT.getMessage());
    }

    public static void validateLastNumber(String numberInput) {
        if (numberInput.isEmpty()) {
            IllegalArgument.handleException(IllegalArgument.WRONG_NUMBERS_INPUT.getMessage());
        }

        if (IsCollection.isDigitText(numberInput)) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.WRONG_NUMBERS_INPUT.getMessage());
    }

    public static void validateBonusNumberInput(String numberInput) {
        if (numberInput.length() > LottoConstant.MAX_INPUT_BONUS_NUMBER_LENGTH) {
            IllegalArgument.handleException(IllegalArgument.OUT_OF_BONUS_NUMBER_LENGTH.getMessage());
        }
    }

    public static void validateDigit(String numberInput) {
        if (numberInput.contains(",")) {
            IllegalArgument.handleException(IllegalArgument.WRONG_NUMBERS_INPUT.getMessage());
        }
    }
}
