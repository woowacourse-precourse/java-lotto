package lotto.domain;

import static lotto.ui.ConsoleMessage.BONUS_NUMBER_DUPLICATE;
import static lotto.ui.ConsoleMessage.INVALID_INPUT_BONUS_NUMBER;
import static lotto.ui.ConsoleMessage.LOTTO_NUMBER_OUT_OF_RANGE;
import static lotto.ui.LottoConsole.printErrorMessage;

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
            printErrorMessage(INVALID_INPUT_BONUS_NUMBER.toString());
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(bonusNumber);
    }

    private void validateNumberRange(int bonusNumber) {
        if (START_NUMBER > bonusNumber || bonusNumber > END_NUMBER) {
            printErrorMessage(LOTTO_NUMBER_OUT_OF_RANGE.toString());
            throw new IllegalArgumentException();
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
            printErrorMessage(BONUS_NUMBER_DUPLICATE.toString());
            throw new IllegalArgumentException();
        }
    }

    public int getNumber() {
        return number;
    }
}
