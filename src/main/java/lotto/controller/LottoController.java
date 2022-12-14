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
        try {
            int purchaseAmount = buyLottery();
            determineWinningNumbers();
            lottoService.calculateRank();
            outputView.printWinningHistory();
            outputView.printProfitRatio(purchaseAmount);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private int buyLottery() {
        outputView.printAskPurchaseAmountMessage();
        int purchaseAmount = inputView.askPurchaseAmount();
        lottoService = new LottoService(purchaseAmount);
        outputView.printGeneratedLottery(purchaseAmount, lottoService.getLotteryInfo());
        return purchaseAmount;
    }

    private void determineWinningNumbers() {
        outputView.printAskWinningNumbersMessage();
        List<Integer> numbers = inputView.askWinningNumbers();
        outputView.printAskBonusNumberMessage();
        Integer bonusNumber = inputView.askBonusNumber();
        lottoService.pickWinningNumbers(numbers, bonusNumber);
    }
}
