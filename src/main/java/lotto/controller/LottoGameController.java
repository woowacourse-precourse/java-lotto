package lotto.controller;

import lotto.service.LottoGameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoGameService lottoGameService = new LottoGameService();

    public void purchaseLotto() {
        String lottoPurchaseAmount = inputView.inputLottoPurchaseAmount();
        int lottoIssueCount = lottoGameService.getLottoIssueCount(lottoPurchaseAmount);
        outputView.printPurchaseLottoCount(lottoIssueCount);
        generateLottoNumbers(lottoIssueCount);
        outputView.printIssuedLottoNumbers(lottoGameService.getPurchaseLottoNumbers());
    }

    public void generateLottoNumbers(int lottoIssueCount) {
        for (int generateIndex = 0; generateIndex < lottoIssueCount; generateIndex++) {
            lottoGameService.addLottoNumberToLottoNumbers();
        }
    }
}
