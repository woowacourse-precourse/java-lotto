package lotto.controller;

import lotto.LottoWinningRank;
import lotto.service.LottoGameService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.Map;

public class LottoGameController {

    private static final String WINNING_NUMBER_KEY = "winningNumber";
    private static final String BONUS_NUMBER_KEY = "bonusNumber";

    private int lottoIssueCount;
    private String lottoPurchaseAmount;

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoGameService lottoGameService = new LottoGameService();

    private final Map<String, String> lottoWinningNumberAndBonusNumberMap = new HashMap<>();

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

    public void setWinningNumberAndBonusNumber() {
        Map<String, String> lottoNumberMap = new HashMap<>();
        String lottoWinningNumbers = inputView.inputLottoWinningNumbers();
        lottoGameService.validateLottoWinningNumbers(lottoWinningNumbers);
        String bonusNumber = inputView.inputLottoBonusNumber();
        lottoGameService.validateBonusNumber(lottoWinningNumbers, bonusNumber);
        lottoWinningNumberAndBonusNumberMap.put("winningNumber", lottoWinningNumbers);
        lottoWinningNumberAndBonusNumberMap.put("bonusNumber", bonusNumber);
    }

    public void decidePurchaseLottosRank() {
        String lottoWinningNumbers = lottoWinningNumberAndBonusNumberMap.get(WINNING_NUMBER_KEY);
        String bonusNumber = lottoWinningNumberAndBonusNumberMap.get(BONUS_NUMBER_KEY);
        for (int purchaseLottoIndex = 0; purchaseLottoIndex < lottoIssueCount; purchaseLottoIndex++) {
            LottoWinningRank lottoWinningRank =
                    lottoGameService.decideWinningRank(
                            lottoGameService.getPurchaseLottoNumbers().get(purchaseLottoIndex),
                            lottoWinningNumbers, bonusNumber);
            lottoGameService.updateWinningRankMap(lottoWinningRank);
        }
    }
}
