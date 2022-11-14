package lotto.domain;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningBonusNumber {
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private static final String ERROR_WINNING_NUMBER_DUPLICATED = "[ERROR] 당첨 번호는 중복되면 안됩니다.";
    private static final String ERROR_WINNING_NUMBER_LENGTH = "[ERROR] 당첨 번호는 6자리여야 합니다.";
    private static final String ERROR_WINNING_NUMBER_RANGE = "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_BONUS_NUMBER_DUPLICATED = "[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.";
    private static final String ERROR_BONUS_NUMBER_RANGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";

    public WinningBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        validateDuplicated(winningNumbers);
        validateNumbersLength(winningNumbers);
        validateNumbersRange(winningNumbers);
    }

    private void validateBonusNumber(int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateDuplicatedBonusNumber(bonusNumber);
    }

    private void validateDuplicated(List<Integer> winningNumbers) {
        Set<Integer> checkDuplicated = new HashSet<>();

        for (int number : winningNumbers) {
            checkDuplicated.add(number);
        }

        if (checkDuplicated.size() != Number.LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBER_DUPLICATED);
        }
    }

    private void validateNumbersLength(List<Integer> winningNumbers) {
        if (winningNumbers.size() != Number.LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBER_LENGTH);
        }
    }

    private void validateNumbersRange(List<Integer> winningNumbers) {
        int min = winningNumbers.stream().sorted().findFirst().get();
        int max = winningNumbers.stream().sorted(Comparator.reverseOrder()).findFirst().get();

        if (min < Number.LOTTO_NUMBER_MIN || max > Number.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBER_RANGE);
        }
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < Number.LOTTO_NUMBER_MIN || bonusNumber > Number.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ERROR_BONUS_NUMBER_RANGE);
        }
    }

    private void validateDuplicatedBonusNumber(int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_BONUS_NUMBER_DUPLICATED);
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
