package lotto.domain;

import java.util.List;
import lotto.utils.CheckException;

public class WinningLotto {
    private final List<Integer> winningNumbers;
    private final int bounsNumber;

    public WinningLotto(List<Integer> winningNumbers, int bounsNumber) {
        CheckException.checkWinningNumbers(winningNumbers);
        CheckException.checkBonusNumber(winningNumbers, bounsNumber);
        this.winningNumbers = winningNumbers;
        this.bounsNumber = bounsNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBounsNumber() {
        return bounsNumber;
    }
}
