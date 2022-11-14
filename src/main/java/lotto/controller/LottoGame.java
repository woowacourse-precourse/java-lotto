package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import java.util.List;

import static lotto.view.OutputView.*;
import static lotto.view.InputView.*;

public class LottoGame {
    static int purchaseAmount;
    static int bonusNumber;
    static List<Integer> winningNumbers;
    static List<Lotto> lottos;

    public void run() {

    }

    public void purchaseLotto() {
        printLottoPurchaseInputNotice();
        purchaseAmount = readAmountOfLottoPrice();

        lottos = LottoService.generateLottoByPurchaseAmount(purchaseAmount);

        printLottoPurchaseResult(lottos);
    }

    public void enterWinningNumber() {
        printWinningNumberInputNotice();
        winningNumbers = readWinningNumbers();
    }

    public void enterBonusNumber() {
        printBonusNumberInputNotice();
        bonusNumber = readBonusNumber();
    }

    public void getResultOfLotto(List<Lotto> lottos, WinningNumber winningNumber) {
        int[] rankingCount = WinningService.compareAllLottoWithWinningNumbers(lottos, winningNumber);
        printWinningStatistics(rankingCount);
    }

    public void getRateOfReturn() {
        long reward = RewardService.calcuateReward(rankingCount);
        double rateOfReturn = RewardService.calculateRateOfReturn(purchaseAmount, reward);
        printRateOfReturn(rateOfReturn);
    }
}
