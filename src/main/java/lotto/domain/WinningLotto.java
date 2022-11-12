package lotto.domain;

import java.util.List;

import static lotto.domain.ErrorMessage.BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE;
import static lotto.domain.ErrorMessage.LOTTO_NUMBER_RANGE_ERROR_MESSAGE;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = new Lotto(winningNumbers);

        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        validateRange(bonusNumber);
        validateDuplicationWithWiningNumbers(bonusNumber);
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < Lotto.MINIMUM_NUMBER || bonusNumber > Lotto.MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    private void validateDuplicationWithWiningNumbers(int bonusNumber) {
        if (winningNumbers.getNumbers()
                .stream()
                .anyMatch(number -> number == bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
