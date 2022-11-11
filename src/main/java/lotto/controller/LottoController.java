package lotto.controller;

import lotto.domain.PurchasedLottos;
import lotto.view.ConsoleView;

public class LottoController {
    private PurchasedLottos purchasedLottos;

    public void process() {
        purchaseLotto();
        showPurchasedLottos();
    }

    private void purchaseLotto() {
        int payment = ConsoleView.inputPurchasePrice();
        purchasedLottos = new PurchasedLottos(payment);
    }

    private void showPurchasedLottos() {
        int amount = purchasedLottos.getLottos().size();
        ConsoleView.printBlankLine();
        ConsoleView.printPurchaseAmount(amount);
        ConsoleView.printPurchasedLottos(purchasedLottos);
    }
}
