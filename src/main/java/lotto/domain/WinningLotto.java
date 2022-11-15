package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {

    private static final String WINNING_NUMBERS_ARE_BETWEEN_ONE_AND_FORTY_FIVE = "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String WINNING_NUMBERS_MUST_BE_SIX_DIFFERENT_NUMBERS = "[ERROR] 당첨 번호는 서로 다른 6개의 수여야 합니다.";
    private static final String BONUS_NUMBER_IS_BETWEEN_ONE_AND_FORTY_FIVE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String WINNING_NUMBERS_CONTAIN_BONUS_NUMBER = "[ERROR] 당첨 번호와 보너스 번호가 중복됩니다.";
    private static final int LOTTO_NUMBER_LOWER_LIMIT = 1;
    private static final int LOTTO_NUMBER_UPPER_LIMIT = 45;
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers);
        validateBonusNumber(bonusNumber);
        validateDuplicate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        if (!isSixDifferentNumbers(winningNumbers)) {
            throw new IllegalArgumentException(WINNING_NUMBERS_MUST_BE_SIX_DIFFERENT_NUMBERS);
        }
        if (!isBetweenOneAndFortyFive(winningNumbers)) {
            throw new IllegalArgumentException(WINNING_NUMBERS_ARE_BETWEEN_ONE_AND_FORTY_FIVE);
        }
    }

    private boolean isBetweenOneAndFortyFive(List<Integer> winningNumbers) {
        for (int winningNumber : winningNumbers) {
            if (winningNumber < LOTTO_NUMBER_LOWER_LIMIT || winningNumber > LOTTO_NUMBER_UPPER_LIMIT) {
                return false;
            }
        }
        return true;
    }

    private boolean isSixDifferentNumbers(List<Integer> winningNumbers) {
        Set<Integer> duplicateChecker = new HashSet<>(winningNumbers);
        return duplicateChecker.size() == LOTTO_NUMBERS_SIZE;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (!isBetweenOneAndFortyFive(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_IS_BETWEEN_ONE_AND_FORTY_FIVE);
        }
    }

    private boolean isBetweenOneAndFortyFive(int bonusNumber) {
        return bonusNumber >= LOTTO_NUMBER_LOWER_LIMIT && bonusNumber <= LOTTO_NUMBER_UPPER_LIMIT;
    }

    private void validateDuplicate(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(WINNING_NUMBERS_CONTAIN_BONUS_NUMBER);
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
