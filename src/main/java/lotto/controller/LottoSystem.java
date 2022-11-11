package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.UserLotto;
import lotto.domain.WinningLotto;

public final class LottoSystem {
    private UserLotto userLotto;
    private WinningLotto winningLotto;
    private BonusNumber bonusNumber;

    public void run() {
        initialize();
    }

    private void initialize() {
        try {
            userLotto = new UserLotto();
            winningLotto = new WinningLotto();
            bonusNumber = new BonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
