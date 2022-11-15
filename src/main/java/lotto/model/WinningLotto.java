package lotto.model;

import java.util.List;

public class WinningLotto {

    private final Lotto winningLottoNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLottoNumbers, int bonusNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningLottoNumbers() {
        return winningLottoNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
