package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.LottoStore;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.domain.strategy.RandomLottoNumberGenerateStrategy;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class LottoController {
    private static final String ERROR_MESSAGE = "[ERROR] ";

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoStore manualLottoStore;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.manualLottoStore = new LottoStore(new RandomLottoNumberGenerateStrategy());
    }

    public void purchaseLotto() {
        try {
            Money purchaseMoney = new Money(inputView.inputPurchaseMoney());
            Lottos purchaseLottos = purchaseLotto(purchaseMoney);
            WinningLotto winningLotto = getWinningLotto();
            result(purchaseMoney, purchaseLottos, winningLotto);
        } catch (Exception exception) {
            System.out.println(ERROR_MESSAGE + exception.getMessage());
        }
    }

    private Lottos purchaseLotto(Money purchaseMoney) {
        Lottos purchaseLottos = this.manualLottoStore.purchaseLotto(purchaseMoney);
        outputView.outputLottos(purchaseLottos);
        return purchaseLottos;
    }

    private WinningLotto getWinningLotto() {
        Lotto winningNumberLotto = new Lotto(inputView.inputWinningLotto());
        LottoNumber bonusNumber = LottoNumber.of(inputView.inputBonusNumber());
        return new WinningLotto(winningNumberLotto, bonusNumber);
    }

    private void result(Money purchaseMoney, Lottos purchaseLottos, WinningLotto winningLotto) {
        LottoResult purchaseLottoResult = purchaseLottos.result(winningLotto);
        outputView.outputLottoResult(purchaseLottoResult);
        outputView.outputYield(purchaseMoney, purchaseLottoResult.reward());
    }
}
