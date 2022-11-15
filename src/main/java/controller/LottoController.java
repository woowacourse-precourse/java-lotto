package controller;

import model.BonusNumber;
import model.EarningsRate;
import model.Lotto;
import model.Lottos;
import model.Money;
import model.WinningLotto;
import model.WinningResult;
import view.InputView;
import view.OutputView;

public class LottoController {
    private static final String ERROR = "[ERROR] ";

    public void play() {
        try {
            Money money = InputView.inputPurchaseAmount();
            Lottos lottos = new Lottos(money);
            OutputView.printLottos(lottos);

            WinningLotto winningLotto = getWinningLotto();

            WinningResult winningResult = lottos.getTotalWinningResult(winningLotto);
            EarningsRate earningsRate = winningResult.getEarningsRate(money);
            OutputView.printWinningResult(winningResult);
            OutputView.printEarningsRate(earningsRate);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR + e.getMessage());
        }
    }

    private WinningLotto getWinningLotto() {
        Lotto winningNumber = InputView.inputWinningNumber();
        BonusNumber bonusNumber = InputView.inputBonusNumber();
        return new WinningLotto(winningNumber, bonusNumber);
    }
}
