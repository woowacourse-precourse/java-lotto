package domain;

import resources.Error;

import java.util.List;

public class WinningNumber {
    private final List<Integer> winningNumbers;

    public WinningNumber(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void hasBeenBonusNumber(int bonusNumber, Error error) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(error.getMsg());
        }
    }
}
