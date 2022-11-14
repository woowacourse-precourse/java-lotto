package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.UserLotto;
import lotto.domain.WinningLotto;
import lotto.view.OutputView;

public class LottoSystem {
    private UserLotto userLotto;
    private WinningLotto winningLotto;
    private BonusNumber bonusNumber;

    public void run() {
        try {
            initialize();
            SettlementSystem.makeResults(winningLotto, userLotto, bonusNumber);
            SettlementSystem.renderResult();
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
