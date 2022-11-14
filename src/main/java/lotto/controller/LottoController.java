package lotto.controller;

import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.WinningNumber;
import lotto.view.LottoConsole;

public class LottoController {

    public void play() {
        try {
            LottoConsole.printPurchaseAmountInput();
            String purchaseAmountStr = LottoConsole.readPurchaseAmount();
            Lottos lottos = new Lottos(purchaseAmountStr);
            LottoConsole.printLottos(lottos);

            LottoConsole.printWinningNumberInput();
            String winningNumberStr = LottoConsole.readWinningNumber();
            LottoConsole.printBonusNumberStr();
            String bonusNumberStr = LottoConsole.readBonusNumber();

            WinningNumber winningNumber = new WinningNumber(winningNumberStr, bonusNumberStr);
            LottoResult lottoResult = new LottoResult(lottos, winningNumber);

            LottoConsole.printLottoResult(lottoResult);
        } catch (IllegalArgumentException e) {
            LottoConsole.printError(e);
        }


    }

}
