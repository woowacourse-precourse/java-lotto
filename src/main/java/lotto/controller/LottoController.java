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

        Lottos lottos = generateLottos(purchaseAmount.getNumberOfLottos());
        WinningNumbers winningNumbers = inputWinningNumbers();

        printLottosInfo(lottos);
        printLottosResult(lottos, winningNumbers);
        printProfitRate(purchaseAmount, lottos, winningNumbers);
    }

    private PurchaseAmount inputPurchaseAmount() {
        int purchaseAmount = inputView.inputPurchaseAmount();
        return new PurchaseAmount(purchaseAmount);
    }

    private WinningNumbers inputWinningNumbers() {
        List<Integer> regularNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber();

        return new WinningNumbers(regularNumbers, bonusNumber);
    }

    private void printNumberOfLottos(PurchaseAmount purchaseAmount) {
        outputView.printNumberOfLottos(purchaseAmount.getNumberOfLottos());
    }

    private void printLottosInfo(Lottos lottos) {
        outputView.printLottos(lottos);
    }

    private void printLottosResult(Lottos lottos, WinningNumbers winningNumbers) {
        outputView.printWinningInfo(lottos.getWinningInfo(winningNumbers));
    }

    private void printProfitRate(PurchaseAmount purchaseAmount, Lottos lottos, WinningNumbers winningNumbers) {
        outputView.printProfitRate(purchaseAmount.calculateProfitRate(lottos.getWinningAmount(winningNumbers)));
    }

    private Lottos generateLottos(int numberOfLottos) {
        return LottoFactory.generate(numberOfLottos);
    }
}
