package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private static final int NUMBER_SIZE = 6;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(distinctNumbers(winningNumbers));
        validateBonusNumber(bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Prize convertToPrize(Lotto lotto) {
        return Prize.findPrize(compareNumbers(lotto), hasBonusNumber(lotto));
    }

    private int compareNumbers(Lotto lotto) {
        return (int) winningNumbers.stream()
                .filter(lotto::hasNumber)
                .count();
    }

    private boolean hasBonusNumber(Lotto lotto) {
        return lotto.hasNumber(bonusNumber);
    }

    private void validateNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("1~45의 수만 입력 가능합니다.");
        }
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }
        winningNumbers.forEach(this::validateNumber);
    }

    private void validateBonusNumber(int bonusNumber) {
        validateNumber(bonusNumber);
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복되면 안됩니다.");
        }
    }

    private List<Integer> distinctNumbers(List<Integer> winningNumbers) {
        return winningNumbers.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
