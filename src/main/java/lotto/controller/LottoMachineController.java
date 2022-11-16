package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachineController {
    public static void operateLottoMachine() {
        LottoMachine lottoMachine = buyLotto();
        WinningStatics winningStatics = enterWinningLotto(lottoMachine);
        printWinningStatics(winningStatics);
    }

    private static LottoMachine buyLotto() {
        int purchaseAmount = InputView.inputPurchaseAmount();
        LottoMachine lottoMachine = new LottoMachine(purchaseAmount);
        OutputView.printPurchaseResults(lottoMachine);
        return lottoMachine;
    }

    private static WinningStatics enterWinningLotto(LottoMachine lottoMachine) {
        Lotto lotto = InputView.inputWinningNumber();
        LottoNumber lottoNumber = InputView.inputBonusNumber();
        return lottoMachine.enterWinningLotto(new WinningLotto(lottoNumber, lotto));
    }

    private static void printWinningStatics(WinningStatics winningStatics) {
        OutputView.printWinningStatics(winningStatics);
    }
}
