package lotto.domain;

import lotto.error.ErrorMessage;
import lotto.util.Validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberBox {
    public final Set<Integer> winningNumbers;

    public final int bonusNumber;

    public NumberBox(List<Integer> winningNumbers, int bonusNumber) {
        validate(winningNumbers);
        this.winningNumbers = new HashSet<>(winningNumbers);
        validate(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Set<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private static void validate(List<Integer> winningNumbers) {
        if (winningNumbers.size() != Validator.LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_LENGTH.getMessage());
        }
        if (!Validator.isInRange(winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_RANGE_WINNING.getMessage());
        }
        if (Validator.isDuplicate(winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBERS.getMessage());
        }
    }

    private static void validate(List<Integer> winningNumbers, int bonusNumber) {
        if (Validator.isDuplicate(winningNumbers, bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.IN_WINNING_NUMBERS.getMessage());
        }
        if (!Validator.isInRange(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_RANGE_BONUS.getMessage());
        }
    }
}
