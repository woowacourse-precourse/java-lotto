package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Calculator;
import lotto.domain.Cost;
import lotto.domain.LotteryDrawMachine;
import lotto.domain.Lotto;
import lotto.domain.LottoGroup;
import lotto.domain.WinningLotto;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    public void run() {
        try {
            Cost cost = createCost();

            int purchaseCount = cost.getCost() / 1000;
            Output.purchaseCountNotification(purchaseCount);

            LottoGroup lottoGroup = createLottoGroup(purchaseCount);
            WinningLotto winningLotto = createWinningLotto();
            BonusNumber bonusNumber = createBonusNumber(winningLotto);

            Calculator calculator = new Calculator();
            List<Integer> matchResults = calculator.calculateMatchResults(lottoGroup, winningLotto,
                    bonusNumber);
            Output.printWinningStatistics(matchResults);

            int profit = calculator.calculateProfit(matchResults);
            double earningsRate = calculator.calculateEarningsRate(cost.getCost(), profit);
            Output.earningsRateNotification(earningsRate);

        } catch (IllegalArgumentException ex) {
            Output.printError(ex.getMessage());
        }
    }

    private Cost createCost() {
        return new Cost(Input.inputCost());
    }

    private LottoGroup createLottoGroup(int purchaseCount) {
        LotteryDrawMachine lotteryDrawMachine = new LotteryDrawMachine();
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < purchaseCount; count++) {
            Lotto lotto = lotteryDrawMachine.createLotto();
            Output.printLotteryNumbers(lotto.getNumbers());
            lottos.add(lotto);
        }
        return new LottoGroup(lottos);
    }

    private WinningLotto createWinningLotto() {
        return new WinningLotto(Input.inputWinningNumbers());
    }

    private BonusNumber createBonusNumber(WinningLotto winningLotto) {
        return new BonusNumber(Input.inputBonusNumbers(), winningLotto);
    }
}
