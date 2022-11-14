package lotto.controller;

import lotto.util.LottoMachine;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.WinningNumber;
import lotto.view.LottoConsole;

public class LottoController {

    public void play() {
        try {
            Lottos lottos = purchaseLottos();

            LottoResult lottoResult = calculateLottoResult(lottos);

            LottoConsole.printLottoResult(lottoResult);
        } catch (IllegalArgumentException e) {
            LottoConsole.printError(e);
        }
    }

    private LottoResult calculateLottoResult(Lottos lottos) {
        String winningNumberStr = LottoConsole.readWinningNumber();
        String bonusNumberStr = LottoConsole.readBonusNumber();

        WinningNumber winningNumber = new WinningNumber(winningNumberStr, bonusNumberStr);
        LottoResult lottoResult = new LottoResult(lottos, winningNumber);
        return lottoResult;
    }

    private Lottos purchaseLottos() {
        String purchaseAmountStr = LottoConsole.readPurchaseAmount();
        Lottos lottos = new Lottos(LottoMachine.generateLottos(purchaseAmountStr), purchaseAmountStr);
        LottoConsole.printLottos(lottos);
        return lottos;
    }

}
