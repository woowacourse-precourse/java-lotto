package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    List<Lotto> userLottos;

    public void runLottoMachine() {
        Money userMoney = Money.from(InputView.inputMoneyByUser());
        userLottos = LottoGenerator.buyMultipleRandomLotto(userMoney);
        OutputView.printUserLottos(userLottos);
        Lotto winningNumber = LottoGenerator.getInputLotto(InputView.inputWinningNumbers());
        String bonusNumber = (InputView.inputBonusNumber());
        WinningLotto winningLotto = WinningLotto.of(winningNumber, bonusNumber);
        Map<Rank, Integer> userLottoScore = winningLotto.getUserLottoScore(userLottos);
        String profitRate = userMoney.calculateProfitRate(getTotalWinningPrize(userLottoScore));
        OutputView.printWinningStatistics(userLottoScore, profitRate);
    }

    private int getTotalWinningPrize(Map<Rank, Integer> userLottoScore) {
        int totalWinningPrize = 0;
        for (int index = 1; index < Rank.values().length; index++) {
            Rank rank = Rank.values()[index];
            totalWinningPrize += userLottoScore.get(rank) * rank.getPrizeMoney();
        }
        return totalWinningPrize;
    }
}