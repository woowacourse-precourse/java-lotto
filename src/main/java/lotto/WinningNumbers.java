package lotto;

import java.util.List;

public class WinningNumbers {
    final Lotto winningNumbers;
    final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }
}
