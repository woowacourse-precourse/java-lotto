package lotto.domain.model;

import java.util.List;

public class WinningLotto {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbersumbers, int bonusNumber) {
        this.winningNumbers = winningNumbersumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
