package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.WinningResult;

public class OutputView {

    public static void lottoPriceOutput(Lottos lottos) {
        System.out.println("\n" + lottos);
    }

    public static void winningNumberOutput(WinningResult winning) {
        System.out.println("\n" + winning);
    }
}
