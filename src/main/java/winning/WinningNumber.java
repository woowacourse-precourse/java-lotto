package winning;

import lotto.Lotto;

import java.util.List;

public class WinningNumber {

    private Lotto winningLotto;
    private int bonusNumber;

    public WinningNumber(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningLotto.getLottoNumber();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
