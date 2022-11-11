package lotto.controller;

import lotto.service.LottoGameService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.Map;

public class LottoGameController {

    private int lottoIssueCount;
    private String lottoPurchaseAmount;

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoGameService lottoGameService = new LottoGameService();

    public void purchaseLotto() {
        lottoPurchaseAmount = inputView.inputLottoPurchaseAmount();
        lottoIssueCount = lottoGameService.getLottoIssueCount(lottoPurchaseAmount);
        outputView.printPurchaseLottoCount(lottoIssueCount);
        generateLottoNumbers();
        outputView.printIssuedLottoNumbers(lottoGameService.getPurchaseLottoNumbers());
    }

    public void generateLottoNumbers() {
        for (int generateIndex = 0; generateIndex < lottoIssueCount; generateIndex++) {
            lottoGameService.addLottoNumberToLottoNumbers();
        }
    }
}
