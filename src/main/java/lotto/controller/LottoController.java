package lotto.controller;

import lotto.domain.PurchasedLottos;
import lotto.view.ConsoleView;

public class LottoController {
    private PurchasedLottos purchasedLottos;

    public void process() {
        purchaseLotto();
    }

    private void purchaseLotto() {
        int payment = ConsoleView.inputPurchasePrice();
        purchasedLottos = new PurchasedLottos(payment);
    }
}
