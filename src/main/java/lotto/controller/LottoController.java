package lotto.controller;

import lotto.domain.generator.NumberGenerator;
import lotto.domain.generator.RandomNumberGenerator;
import lotto.domain.lottery.BonusNumber;
import lotto.domain.Cost;
import lotto.domain.lottery.LottoGroup;
import lotto.domain.lottery.WinningLotto;
import lotto.domain.result.Profit;
import lotto.domain.result.Result;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    public void run() {
        try {
            Cost cost = createCost();
            int purchaseCost = cost.getCost();
            int purchaseCount = cost.getPurchaseCount();
            Output.purchaseCountNotification(purchaseCount);

            NumberGenerator randomNumberGenerator = new RandomNumberGenerator();
            LottoGroup lottoGroup = createLottoGroup(purchaseCount, randomNumberGenerator);
            Output.printLottoGroup(lottoGroup);

            WinningLotto winningLotto = createWinningLotto();
            BonusNumber bonusNumber = createBonusNumber(winningLotto);

            Result result = createResult(lottoGroup, winningLotto, bonusNumber);
            Output.printWinningStatistics(result);

            Profit profit = createProfit(purchaseCost, result);
            Output.earningsRateNotification(profit.getEarningsRate());
        } catch (IllegalArgumentException ex) {
            Output.printError(ex.getMessage());
        }
    }

    private Result createResult(LottoGroup lottoGroup, WinningLotto winningLotto, BonusNumber bonusNumber) {
        return new Result(lottoGroup, winningLotto, bonusNumber);
    }

    private Profit createProfit(int purchaseCost, Result result) {
        return new Profit(purchaseCost, result);
    }

    private Cost createCost() {
        return new Cost(Input.inputCost());
    }

    private LottoGroup createLottoGroup(int purchaseCount, NumberGenerator numberGenerator) {
        return new LottoGroup(purchaseCount, numberGenerator);
    }

    private WinningLotto createWinningLotto() {
        return new WinningLotto(Input.inputWinningNumbers());
    }

    private BonusNumber createBonusNumber(WinningLotto winningLotto) {
        return new BonusNumber(Input.inputBonusNumbers(), winningLotto);
    }
}
