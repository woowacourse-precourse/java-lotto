package lotto.exception;

import lotto.enums.Message;
import java.util.List;

public class LottoWinningNumber extends Lotto {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final int LOTTO_START_NUMBER = 1;
    private final int LOTTO_END_NUMBER = 45;

    public LottoWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        super(winningNumbers);
        this.winningNumbers = winningNumbers;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        validateBonusNumbersRange(bonusNumber);
        checkDuplicateBonusNumber(winningNumbers, bonusNumber);
    }

    private void validateBonusNumbersRange(int bonusNumber) {
        if (LOTTO_START_NUMBER > bonusNumber || bonusNumber > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(Message.ERROR_NUMBER_RANGE.getMessage());
        }
    }

    private void checkDuplicateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(Message.ERROR_DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
}
