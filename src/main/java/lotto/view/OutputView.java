package lotto.view;

import lotto.domain.LottoMachine;
import lotto.domain.WinningStatics;

public class OutputView {

    public static void printPurchaseResults(LottoMachine lottoMachine) {
        System.out.println(lottoMachine);
    }

    public static void printWinningStatics(WinningStatics winningStatics) {
        System.out.println(winningStatics);
    }
}
