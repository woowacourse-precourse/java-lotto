package lotto.controller;

import lotto.model.LottoFactory;
import lotto.model.Lottos;
import lotto.model.PurchaseAmount;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();

    public void run() {
        PurchaseAmount purchaseAmount = inputPurchaseAmount();

        printNumberOfLottos(purchaseAmount);

        Lottos lottos = purchaseLottos(purchaseAmount);
        WinningNumbers winningNumbers = inputWinningNumbers();

        printLottos(lottos);
        printLottosResult(lottos, winningNumbers);
        printLottosProfitRate(purchaseAmount, lottos, winningNumbers);
    }

    private PurchaseAmount inputPurchaseAmount() {
        int purchaseAmount = inputView.inputPurchaseAmount();
        return new PurchaseAmount(purchaseAmount);
    }

    private WinningNumbers inputWinningNumbers() {
        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber();

        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    private void printNumberOfLottos(PurchaseAmount purchaseAmount) {
        outputView.printNumberOfLottos(purchaseAmount.getNumberOfLottos());
    }

    private void printLottos(Lottos lottos) {
        outputView.printLottos(lottos);
    }

    private void printLottosResult(Lottos lottos, WinningNumbers winningNumbers) {
        outputView.printLottosResult(lottos.getLottosResult(winningNumbers));
    }

    private void printLottosProfitRate(PurchaseAmount purchaseAmount, Lottos lottos, WinningNumbers winningNumbers) {
        int winningAmount = lottos.calculateWinningAmount(winningNumbers);
        double profitRate = purchaseAmount.calculateProfitRate(winningAmount);

        outputView.printProfitRate(profitRate);
    }

    private Lottos purchaseLottos(PurchaseAmount purchaseAmount) {
        return LottoFactory.generate(purchaseAmount.getNumberOfLottos());
    }
}
