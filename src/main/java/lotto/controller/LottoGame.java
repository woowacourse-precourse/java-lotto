package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    public void start() {
        try {
            OutputView.printInputMoney();
            Money money = new Money(InputView.inputPurchaseMoney());
            Lottos lottos = makeLotto(money.countLotto());
            winStatics(lottos, drawLottery(), money);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }

    private Lottos makeLotto(int lottoCount) {
        Lottos lottos = new Lottos(LottoGenerator.generateLottos(lottoCount));
        OutputView.printPurchaseLotto(lottos.getLottos());
        return lottos;
    }

    private WinningLotto drawLottery() {
        OutputView.printInputWinningNumber();
        Lotto winningLottoNumber = new Lotto(InputView.inputWinningNumber());

        OutputView.printInputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningLottoNumber,
                InputView.inputBonusNumber());
        return winningLotto;
    }

    private void winStatics(Lottos lottos, WinningLotto winningLotto, Money money) {
        LottoResult lottoResult = new LottoResult(lottos, winningLotto, money);
        OutputView.printResult(lottoResult);
    }
}