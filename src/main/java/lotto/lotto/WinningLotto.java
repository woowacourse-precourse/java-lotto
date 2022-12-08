package lotto.lotto;

import lotto.Exception.Exception;
import lotto.lotto.Lotto;

public class WinningLotto {
    private Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        checkBonusNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void checkBonusNumber(Lotto lotto, int bonusNumber) {
        Exception.checkBonusInLotto(lotto, bonusNumber);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
