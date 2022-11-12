package lotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoMaker;
import lotto.domain.result.Result;
import lotto.domain.result.ResultMaker;
import lotto.domain.utils.ProfitCalculator;
import lotto.io.ConsoleInput;
import lotto.io.ConsoleOutput;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static int purchaseAmount;
    private static List<Lotto> lottos;
    private static List<Integer> winningNumbers;
    private static int bonusNumber;
    private static List<Result> results = new ArrayList<>();

    public static void main(String[] args) {
        try {
            getPurchaseAmount();
            makeLottos();
            getWinningNumbers();
            getBonusNumber();
            makeLottoResults();
            printStatistics();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void getPurchaseAmount() throws Exception {
        ConsoleOutput.printGuide(ConsoleOutput.PURCHASE_AMOUNT);
        purchaseAmount = ConsoleInput.getPurchaseAmount();
        System.out.println();
    }

    private static void makeLottos() throws Exception {
        lottos = LottoMaker.makeLotto(purchaseAmount);
        ConsoleOutput.printNumOfLotto(purchaseAmount/LottoMaker.ONE_LOTTO_PRICE);
        ConsoleOutput.printLottos(lottos);
        System.out.println();
    }

    private static void getWinningNumbers() throws Exception {
        ConsoleOutput.printGuide(ConsoleOutput.WINNING_NUMBER);
        winningNumbers = ConsoleInput.getWinningNumbers();
        System.out.println();
    }

    private static void getBonusNumber() throws Exception {
        ConsoleOutput.printGuide(ConsoleOutput.BONUS_NUMBER);
        bonusNumber = ConsoleInput.getBonusNumber();
        System.out.println();
    }

    private static void makeLottoResults() {
        ResultMaker resultMaker = new ResultMaker(winningNumbers, bonusNumber);
        for (Lotto lotto : lottos) {
            results.add(resultMaker.getTheResult(lotto.getNumbers()));
        }
    }

    private static void printStatistics() {
        ConsoleOutput.printWinningStatistics(results, ProfitCalculator.getProfit(results, purchaseAmount));
    }
}
