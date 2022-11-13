package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.UserLotto;
import lotto.domain.WinningLotto;
import lotto.view.OutputView;

public final class LottoSystem {
    private UserLotto userLotto;
    private WinningLotto winningLotto;
    private BonusNumber bonusNumber;

    public void run() {
        try {
            initialize();
            SettlementSystem.startProcess(winningLotto, userLotto, bonusNumber);

        } catch (IllegalArgumentException e) {
            OutputView.printIOMessage(e.getMessage());
        }
    }

    private void initialize() {
        userLotto = new UserLotto();
        winningLotto = new WinningLotto();
        bonusNumber = new BonusNumber();
    }
}
