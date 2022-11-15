package lotto.controller;

import lotto.domain.Award;
import lotto.domain.manager.AwardManager;
import lotto.domain.BonusNumber;
import lotto.domain.UserLotto;
import lotto.domain.WinningLotto;
import lotto.domain.manager.YieldManager;
import lotto.view.OutputView;

import java.util.List;

public class SettlementSystem {
    private List<Award> awards;
    private float yield;

    public void makeResults(WinningLotto winningLotto, UserLotto userLotto, BonusNumber bonusNumber) {
        awards = AwardManager.makeAwards(winningLotto, userLotto, bonusNumber);
        yield = YieldManager.makeYield(awards);
    }

    public void renderResult() {
        OutputView.printReward(awards);
        OutputView.printYield(yield);
    }
}
