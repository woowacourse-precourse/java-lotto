package lotto.controller;

import static lotto.view.OutputView.*;
import static lotto.view.InputView.*;

import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.service.LottoService;
import lotto.service.RewardService;
import lotto.service.WinningService;
import java.util.List;


public class LottoGame {
    static int purchaseAmount;
    static int bonusNumber;
    static int[] rankingCount;
    static List<Integer> winningNumbers;
    static List<Lotto> lottos;
    static WinningNumber winningNumber;

    public void run() {
        purchaseLotto();
        enterWinningNumber();
        enterBonusNumber();
        winningNumber = new WinningNumber(winningNumbers, bonusNumber);
        getResultOfLotto();
        getRateOfReturn();
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

    public void getResultOfLotto() {
        rankingCount = WinningService.compareAllLottoWithWinningNumbers(lottos, winningNumber);
        printWinningStatistics(rankingCount);
    }

    public void getRateOfReturn() {
        long reward = RewardService.calcuateReward(rankingCount);
        double rateOfReturn = RewardService.calculateRateOfReturn(purchaseAmount, reward);
        printRateOfReturn(rateOfReturn);
    }
}
