package lotto.exception;

import lotto.enums.Message;
import java.util.List;

public class LottoWinningNumber extends Lotto {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

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
        if (ConstantValue.LOTTO_START_NUMBER > bonusNumber || bonusNumber > ConstantValue.LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(Message.ERROR_NUMBER_RANGE.getMessage());
        }
    }

    private void checkDuplicateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(Message.ERROR_DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
}
