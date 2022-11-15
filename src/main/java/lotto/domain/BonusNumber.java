package lotto.domain;

import static lotto.ui.ConsoleMessage.BONUS_NUMBER_DUPLICATE;
import static lotto.ui.ConsoleMessage.INVALID_INPUT_BONUS_NUMBER;
import static lotto.ui.ConsoleMessage.LOTTO_NUMBER_OUT_OF_RANGE;

public class BonusNumber {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;

    private final int number;

    public BonusNumber(String bonusNumber, Lotto winningLottoNumbers) {
        int validatedBonusNumber = validateBonusNumber(bonusNumber, winningLottoNumbers);
        number = validatedBonusNumber;
    }

    private int validateBonusNumber(String bonusNumber, Lotto winningLottoNumbers) {
        int validatedNumber = validateInputType(bonusNumber);
        validateNumberRange(validatedNumber);
        return validateDuplicate(validatedNumber, winningLottoNumbers);
    }

    private int validateInputType(String bonusNumber) {
        if (!bonusNumber.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(INVALID_INPUT_BONUS_NUMBER.toString());
        }
        return Integer.parseInt(bonusNumber);
    }

    private void validateNumberRange(int bonusNumber) {
        if (START_NUMBER > bonusNumber || bonusNumber > END_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE.toString());
        }
    }

    private int validateDuplicate(int bonusNumber, Lotto winningLottoNumbers) {
        for (Integer winningNumber :
                winningLottoNumbers.getNumbers()) {
            checkforSameNumber(winningNumber, bonusNumber);
        }
        return bonusNumber;
    }

    private void checkforSameNumber(int winningNumber, int bonusNumber) {
        if (winningNumber == bonusNumber) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE.toString());
        }
    }

    public int getNumber() {
        return number;
    }
}
