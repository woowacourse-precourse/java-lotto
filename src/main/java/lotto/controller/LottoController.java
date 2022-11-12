package lotto.controller;

import lotto.domain.Lotto;
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
        Lotto lotto = createWinningNumbers();
        int bonusNumber = createBonusNumber();
        winningLotto = new WinningLotto(lotto, bonusNumber);
    }

    private Lotto createWinningNumbers() {
        ConsoleView.printBlankLine();
        List<Integer> numbers = ConsoleView.inputWinningNumbers();
        return new Lotto(numbers);
    }

    private int createBonusNumber() {
        ConsoleView.printBlankLine();
        return ConsoleView.inputBonusNumber();
    }
}
