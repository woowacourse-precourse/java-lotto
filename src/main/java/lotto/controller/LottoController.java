package lotto.controller;

import lotto.domain.PurchasedAmount;
import lotto.domain.PurchasedLottos;
import lotto.domain.Result;
import lotto.domain.WinningLotto;
import view.InputView;
import view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        final PurchasedAmount purchasedAmount = inputView.inputPurchasedAmount();
        final PurchasedLottos purchasedLottos = new PurchasedLottos(purchasedAmount.getCount());

        outputView.printPurchasedLottos(purchasedAmount.getCount(), purchasedLottos);

        final WinningLotto winningLotto = inputView.inputWinningLottoNumber();

        final Result result = makeResult(winningLotto, purchasedLottos);

        outputView.printResult(result, purchasedAmount.getPrice());
    }

    private Result makeResult(WinningLotto winningLotto, PurchasedLottos purchasedLottos) {
        final Result tmpResult = new Result();

        purchasedLottos.getPurchasedLottos()
                .stream()
                .map(winningLotto::compareLottoNumber)
                .forEach(tmpResult::add);

        return tmpResult;
    }

}
