package lotto.controller;

import lotto.domain.PurchasedLottos;
import lotto.domain.WinningLotto;
import lotto.view.ConsoleView;

import java.util.List;

public class LottoController {
    private PurchasedLottos purchasedLottos;
    private WinningLotto winningLotto;

    public void process() {
        purchaseLotto();
        showPurchasedLottos();
        setWinningLotto();
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

    private void setWinningLotto() {
        ConsoleView.printBlankLine();
        List<Integer> numbers = ConsoleView.inputWinningLotto();
        ConsoleView.printBlankLine();
        int bonusNumber = ConsoleView.inputBonusNumber();
        winningLotto = new WinningLotto(numbers, bonusNumber);
    }
}
