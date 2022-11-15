package lotto.input.validation;

import lotto.input.validation.code.BonusNumberValidationCode;

import java.util.List;

public class BonusNumberValidator {
    public BonusNumberValidationCode validateBonusNumber(String token, List<Integer> winningNumbers) {
        if (!isTokenNumber(token) || !isNumberFormatValid(token)) {
            return BonusNumberValidationCode.INVALID_FORMAT;
        }
        int bonusNumber = Integer.parseInt(token);
        if (!isNumberInRange(bonusNumber)) {
            return BonusNumberValidationCode.NUMBER_OUT_OF_RANGE;
        }
        if (!isNumberDistinctFromWinningNumbers(bonusNumber, winningNumbers)) {
            return BonusNumberValidationCode.DUPLICATE_EXIST_IN_WINNING_NUMBERS;
        }
        return BonusNumberValidationCode.VALID;
    }

    private boolean isTokenNumber(String token) {
        try {
            Integer.parseInt(token);
        } catch (NumberFormatException exception) {
            return false;
        }
        return true;
    }

    private boolean isNumberFormatValid(String token) {
        return token.charAt(0) >= '1' && token.charAt(0) <= '9';
    }

    private boolean isNumberInRange(int number) {
        return number >= 1 && number <= 45;
    }

    private boolean isNumberDistinctFromWinningNumbers(int number, List<Integer> winningNumbers) {
        return !winningNumbers.contains(number);
    }
}
