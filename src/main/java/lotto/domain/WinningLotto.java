package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
        validateWinningLottoContainsBonusNumber(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningLottoContainsBonusNumber(Lotto winningLotto, BonusNumber bonusNumber) {
        if (winningLotto.containsBonusNumber(bonusNumber.getNumber())) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getWinningLottoNumbers() {
        return winningLotto.getNumbers();
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}