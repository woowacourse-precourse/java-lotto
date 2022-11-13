package lotto.controller;

import lotto.domain.PurchasedAmount;
import lotto.domain.PurchasedLottos;
import view.InputView;
import view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        final PurchasedAmount purchasedAmount = getPurchasedAmount();
        if (purchasedAmount == null) {
            return;
        }

        final PurchasedLottos purchasedLottos = new PurchasedLottos(purchasedAmount.getCount());

        outputView.printPurchasedLottos(purchasedAmount.getCount(), purchasedLottos);
    }

    private PurchasedAmount getPurchasedAmount() {
        try {
            return inputView.inputPurchasedAmount();
        } catch (IllegalArgumentException exception) {
            outputView.getErrorMessage(exception.getMessage());
            return null;
        }
    }
}
