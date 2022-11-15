package lotto.model;

import java.util.List;

public class BonusNumber {
    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 45;
    private final int bonusNumber;

    public BonusNumber(int inputNumber, WinningNumbers winningNumbers) {
        validate(inputNumber, winningNumbers.getWinningNumbers());
        this.bonusNumber = inputNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(int inputNumber, List<Integer> winningNumbers) {
        isInCorrectRange(inputNumber);
        isContainsWinningNumbers(inputNumber, winningNumbers);
    }

    private void isInCorrectRange(int inputNumber) {
        if (inputNumber < MIN_NUMBER_RANGE || inputNumber > MAX_NUMBER_RANGE) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] 보너스 번호는 %d부터 %d사이의 숫자여야 합니다.", MIN_NUMBER_RANGE, MAX_NUMBER_RANGE));
        }
    }

    private void isContainsWinningNumbers(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }
}
