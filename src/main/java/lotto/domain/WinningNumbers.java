package lotto.domain;

import java.util.List;

public class WinningNumbers {

    private List<Integer> winningLotto;
    private int bonusNumber;

    public WinningNumbers(List<Integer> winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningLotto() {
        return this.winningLotto;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
