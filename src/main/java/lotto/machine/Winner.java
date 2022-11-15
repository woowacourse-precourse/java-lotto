package lotto.machine;

import static lotto.Constants.*;

import java.util.List;

public class Winner {
    private final Integer bonusNumber;
    private final Lotto winningNumbers;

    public Winner(List<Integer> winningNumbers, Integer bonusNumber) {
        validateBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getNumbers();
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    private void validateBonusNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        validateRange(bonusNumber);
        validateIfWinningNumbersContainBonusNumber(winningNumbers, bonusNumber);
    }

    private void validateRange(Integer number) {
        if (number < START_NUMBER_INCLUSIVE || number > END_NUMBER_INCLUSIVE) {
            throw new IllegalArgumentException(ERROR_TITLE + OUT_OF_RANGE);
        }
    }

    private void validateIfWinningNumbersContainBonusNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_TITLE + DUPLICATE_NUMBERS);
        }
    }
}
