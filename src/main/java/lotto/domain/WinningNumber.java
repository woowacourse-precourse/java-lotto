package lotto.domain;

import lotto.util.ErrorMessage;
import lotto.util.LottoConstant;
import java.util.HashSet;
import java.util.List;

public class WinningNumber {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean isContainedInWinningNumber(int number) {
        return winningNumbers.contains(number);
    }

    public boolean isEqualToBonusNumber(int number) {
        return bonusNumber == number;
    }

    private void validate(List<Integer> winningNumbers, int bonusNumber) {
        validateNumberCount(winningNumbers);
        validateNumbersRange(winningNumbers);
        validateNumberRange(bonusNumber);
        validateDuplication(winningNumbers);
        validateContainsInWinningNumber(winningNumbers, bonusNumber);
    }

    private void validateNumberCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LottoConstant.NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private void validateNumbersRange(List<Integer> winningNumbers) {
        winningNumbers.forEach(this::validateNumberRange);
    }

    private void validateNumberRange(int number) {
        if (number < LottoConstant.START_NUMBER.getValue() || number > LottoConstant.END_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private void validateContainsInWinningNumber(List<Integer> winningNumbers, int number) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION_BONUS_NUMBER.getMessage());
        }
    }

    private void validateDuplication(List<Integer> winningNumbers) {
        if (new HashSet<>(winningNumbers).size() != LottoConstant.NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }
}
