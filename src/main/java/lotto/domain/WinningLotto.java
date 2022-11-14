package lotto.domain;

import lotto.view.InputView;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public static WinningLotto create() {
        Lotto winningLotto = new Lotto(new InputView().readWinningLotto());
        int bonusNumber = new InputView().readBonusNumber();

        return new WinningLotto(winningLotto, bonusNumber);
    }

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.lotto = winningLotto;
        winningLotto.validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getMatchCountWith(Lotto lotto) {
        return lotto.getMatchCountWith(this.lotto);
    }

    public boolean isBonusNumberIn(Lotto lotto) {
        return lotto.contain(bonusNumber);
    }
}
