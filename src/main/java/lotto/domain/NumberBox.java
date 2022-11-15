package lotto.domain;

import lotto.util.Validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberBox {
    private static final String WRONG_LENGTH = "[ERROR] 로또 번호는 6개의 숫자여야 합니다.";
    private static final String DUPLICATE_NUMBERS = "[ERROR] 로또 번호는 중복되지 않는 숫자들로 구성되어야 합니다.";
    private static final String IN_WINNING_NUMBERS = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String NOT_IN_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
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
            throw new IllegalArgumentException(WRONG_LENGTH);
        }
        if (Validator.isDuplicate(winningNumbers)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBERS);
        }
        if (!Validator.isInRange(winningNumbers)) {
            throw new IllegalArgumentException(NOT_IN_RANGE);
        }
    }

    private static void validate(List<Integer> winningNumbers, int bonusNumber) {
        if (Validator.isDuplicate(winningNumbers, bonusNumber)) {
            throw new IllegalArgumentException(IN_WINNING_NUMBERS);
        }
        if (!Validator.isInRange(bonusNumber)) {
            throw new IllegalArgumentException(NOT_IN_RANGE);
        }
    }
}
