package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Calculator;
import lotto.domain.Cost;
import lotto.domain.LotteryDrawMachine;
import lotto.domain.Lotto;
import lotto.domain.LottoGroup;
import lotto.domain.WinningLotto;
import lotto.view.Output;

public class LottoController {

    public void run() {
        LotteryDrawMachine lotteryDrawMachine = new LotteryDrawMachine();

        Output.enterPurchaseCost();
        Cost cost;
        try {
            String purchaseCost = Console.readLine();
            cost = new Cost(purchaseCost);
        } catch (IllegalArgumentException ex) {
            Output.printError(ex.getMessage());
            return;
        }

        int purchaseCount = cost.getCost() / 1000;
        Output.purchaseCountNotification(purchaseCount);

        List<Lotto> lottos = new ArrayList<>();
        try {
            for (int count = 0; count < purchaseCount; count++) {
                Lotto lotto = lotteryDrawMachine.createLotto();
                System.out.println(lotto.getNumbers());
                lottos.add(lotto);
            }
        } catch (IllegalArgumentException ex) {
            Output.printError(ex.getMessage());
            return;
        }
        LottoGroup lottoGroup = new LottoGroup(lottos);


        Output.enterWinningNumbers();
        String inputWinningNumbers = Console.readLine();
        WinningLotto winningLotto;
        try {
            winningLotto = new WinningLotto(inputWinningNumbers);
        } catch (IllegalArgumentException ex) {
            Output.printError(ex.getMessage());
            return;
        }

        Output.enterBonusNumber();
        String inputBonusNumber = Console.readLine();
        BonusNumber bonusNumber;
        try {
            bonusNumber = new BonusNumber(inputBonusNumber, winningLotto);
        } catch (IllegalArgumentException ex) {
            Output.printError(ex.getMessage());
            return;
        }

        Output.winningStatistics();
        Calculator calculator = new Calculator();
        List<Integer> matchResults = calculator.calculateMatchResults(lottoGroup, winningLotto,
                bonusNumber);
        Output.printWinningStatistics(matchResults);

        int profit = calculator.calculateProfit(matchResults);
        double earningsRate = calculator.calculateEarningsRate(cost.getCost(), profit);
        Output.earningsRateNotification(earningsRate);
    }
}
