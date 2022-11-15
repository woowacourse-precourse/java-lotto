package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Profit;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningResult;
import lotto.view.OutputView;

public class LottoController {

    private static Lottos lottos;

    private static WinningNumbers winningNumbers;

    private static WinningResult winningResult;

    private static Profit profit;

    public static void play() {
        try {
            generateLotto();
            calculateWinningResult();
            calculateProfit();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void generateLotto() {
        lottos = new Lottos();
        OutputView.lottoPriceOutput(lottos);
    }

    private static void calculateWinningResult() {
        winningNumbers = new WinningNumbers();
        winningResult = new WinningResult(lottos, winningNumbers);
        OutputView.winningResultOutput(winningResult);
    }

    private static void calculateProfit() {
        profit = new Profit(lottos, winningResult);
        OutputView.profitOutput(profit);
    }
}
