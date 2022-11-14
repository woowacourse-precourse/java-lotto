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
        int amount = inputView.inputPurchaseAmount();
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);

        int numberOfLottos = purchaseAmount.getNumberOfLottos();
        outputView.printNumberOfLottos(numberOfLottos);

        Lottos lottos = LottoFactory.generate(numberOfLottos);
        outputView.printLottos(lottos);

        List<Integer> regularNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber();

        WinningNumbers winningNumbers = new WinningNumbers(regularNumbers, bonusNumber);

        outputView.printWinningInfo(lottos.getWinningInfo(winningNumbers));

        outputView.printProfitRate(purchaseAmount.calculateProfitRate(lottos.getWinningAmount(winningNumbers)));
    }
}
