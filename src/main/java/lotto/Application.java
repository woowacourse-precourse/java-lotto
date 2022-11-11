package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Calculator;
import lotto.domain.LotteryDrawMachine;
import lotto.domain.Lotto;
import lotto.util.InputValidator;
import lotto.util.TypeConverter;
import lotto.view.Output;

public class Application {

    public static void main(String[] args) {
        LotteryDrawMachine lotteryDrawMachine = new LotteryDrawMachine();

        Output.enterPurchaseCost();
        String purchaseCost = Console.readLine();
        if (!InputValidator.checkPurchaseCost(purchaseCost)) {
            return;
        }

        int purchaseCount = Integer.parseInt(purchaseCost) / 1000;
        Output.purchaseCountNotification(purchaseCount);

        List<List<Integer>> groupOfUserLotteryNumbers = new ArrayList<>();

        for (int count = 0; count < purchaseCount; count++) {
            List<Integer> lotteryNumbers = lotteryDrawMachine.drawLotteryNumbers();
            Lotto lotto = new Lotto(lotteryNumbers);
            groupOfUserLotteryNumbers.add(lotteryNumbers);
        }

        Output.enterWinningNumbers();
        String strWinningNumbers = Console.readLine();
        if (!InputValidator.checkWinningNumbers(strWinningNumbers)) {
            return;
        }
        List<Integer> winningNumbers = TypeConverter.toIntegerListByComma(strWinningNumbers);

        Output.enterBonusNumber();
        int bonusNumber = Integer.parseInt(Console.readLine());

        Output.winningStatistics();
        Calculator calculator = new Calculator();
        List<Integer> matchResults = calculator.calculateMatchResults(groupOfUserLotteryNumbers, winningNumbers,
                bonusNumber);
        Output.printWinningStatistics(matchResults);

        int profit = calculator.calculateProfit(matchResults);
        double earningsRate = calculator.calculateEarningsRate(Integer.parseInt(purchaseCost), profit);
        Output.earningsRateNotification(earningsRate);
    }
}
