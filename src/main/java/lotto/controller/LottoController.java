package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Calculator;
import lotto.domain.LotteryDrawMachine;
import lotto.domain.Lotto;
import lotto.domain.LottoGroup;
import lotto.util.InputValidator;
import lotto.util.TypeConverter;
import lotto.view.Output;

public class LottoController {

    public void run() {
        LotteryDrawMachine lotteryDrawMachine = new LotteryDrawMachine();

        Output.enterPurchaseCost();
        String purchaseCost = Console.readLine();
        if (!InputValidator.checkPurchaseCost(purchaseCost)) {
            return;
        }

        int purchaseCount = Integer.parseInt(purchaseCost) / 1000;
        Output.purchaseCountNotification(purchaseCount);

        List<Lotto> lottos = new ArrayList<>();

        for (int count = 0; count < purchaseCount; count++) {
            Lotto lotto = lotteryDrawMachine.createLotto();
            lottos.add(lotto);
        }
        LottoGroup lottoGroup = new LottoGroup(lottos);


        Output.enterWinningNumbers();
        String strWinningNumbers = Console.readLine();
        if (!InputValidator.checkWinningNumbers(strWinningNumbers)) {
            return;
        }
        List<Integer> winningNumbers = TypeConverter.toIntegerListByComma(strWinningNumbers);
        Lotto lotto = new Lotto(winningNumbers);

        Output.enterBonusNumber();
        String bonusNumber = Console.readLine();
        if (!InputValidator.checkBonusNumber(bonusNumber, winningNumbers)) {
            return;
        }

        Output.winningStatistics();
        Calculator calculator = new Calculator();
        List<Integer> matchResults = calculator.calculateMatchResults(lottoGroup, winningNumbers,
                Integer.parseInt(bonusNumber));
        Output.printWinningStatistics(matchResults);

        int profit = calculator.calculateProfit(matchResults);
        double earningsRate = calculator.calculateEarningsRate(Integer.parseInt(purchaseCost), profit);
        Output.earningsRateNotification(earningsRate);
    }
}
