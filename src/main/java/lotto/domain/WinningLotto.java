package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {

    private Lotto winningNumber;
    private int bonusNumber;

    WinningLotto(Lotto winningNumber, int bonusNumber) {
        validateBonusDuplication(winningNumber,bonusNumber);
        validateBonusNumberScope(bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void validateBonusDuplication(Lotto winningNumber, int bonusNumber) {
        if (winningNumber.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(Lotto.DUPLICATION_ERROR_MESSAGE);
        }
    }

    public void validateBonusNumberScope(int bonusNumber) {
        if (!(bonusNumber >= Lotto.MIN_VALUE && bonusNumber <= Lotto.MAX_VALUE)) {
            throw new IllegalArgumentException(Lotto.SCOPE_ERROR_MESSAGE);
        }
    }

}
