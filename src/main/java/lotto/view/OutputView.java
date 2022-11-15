package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.Profit;
import lotto.domain.WinningResult;

public class OutputView {

    public static void lottoPriceOutput(Lottos lottos) {
        System.out.println("\n" + lottos);
    }

    public static void winningResultOutput(WinningResult winning) {
        System.out.println("\n" + winning);
    }

    public static void profitOutput(Profit profit) {
        System.out.println("\n" + profit);
    }
}
