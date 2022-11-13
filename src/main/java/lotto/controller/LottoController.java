package lotto.controller;

import java.util.List;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int purchaseAmount = buyLottery();
        determineWinningNumbers();

        lottoService.calculateRank();
        outputView.printWinningHistory();
        outputView.printProfitRatio(purchaseAmount);
    }

    private void determineWinningNumbers() {
        outputView.printAskWinningNumbersMessage();
        List<Integer> numbers = inputView.getWinningNumbers();
        outputView.printAskBonusNumberMessage();
        Integer bonusNumber = inputView.getBonusNumber();
        lottoService.pickWinningNumbers(numbers, bonusNumber);
    }

    private int buyLottery() {
        outputView.printAskPurchaseAmountMessage();
        int purchaseAmount = inputView.getPurchaseAmount();
        lottoService = new LottoService(purchaseAmount);
        outputView.printGeneratedLottery(purchaseAmount, lottoService.getLotteryInfo());
        return purchaseAmount;
    }
}
