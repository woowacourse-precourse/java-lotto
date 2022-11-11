package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.UserLotto;
import lotto.domain.WinningLotto;

public final class LottoSystem {
    private final UserLotto userLotto = new UserLotto();
    private final WinningLotto winningLotto = new WinningLotto();
    private final BonusNumber bonusNumber = new BonusNumber();

    public void run() {
        userLotto.printMyLotto();
    }
}
