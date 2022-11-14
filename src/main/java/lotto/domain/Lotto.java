package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public Lotto(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbersSize(winningNumbers);
        this.bonusNumber = bonusNumber;
        this.winningNumbers = winningNumbers;
    }

    private void validateWinningNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
