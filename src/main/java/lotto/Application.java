package lotto;

import lotto.domain.*;
import lotto.io.ConsoleInput;
import lotto.io.ConsoleOutput;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        ConsoleOutput.printGuide(ConsoleOutput.PURCHASE_AMOUNT);
        int purchaseAmount = ConsoleInput.getPurchaseAmount();
        List<Lotto> lottos = LottoMaker.makeLotto(purchaseAmount);
        System.out.println();

        ConsoleOutput.printNumOfLotto(purchaseAmount/LottoMaker.ONE_LOTTO_PRICE);
        ConsoleOutput.printLottos(lottos);
        System.out.println();

        ConsoleOutput.printGuide(ConsoleOutput.WINNING_NUMBER);
        List<Integer> winningNumbers = ConsoleInput.getWinningNumbers();
        System.out.println();
        ConsoleOutput.printGuide(ConsoleOutput.BONUS_NUMBER);
        int bonusNumber = ConsoleInput.getBonusNumber();
        System.out.println();
        ResultMaker resultMaker = new ResultMaker(winningNumbers, bonusNumber);

        List<Result> results = new ArrayList<>();
        for (Lotto lotto : lottos) {
            results.add(resultMaker.getTheResult(lotto.getNumbers()));
        }
        ConsoleOutput.printWinningStatistics(results, ProfitCalculator.getProfit(results, purchaseAmount));
    }
}
