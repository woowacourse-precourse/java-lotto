package controller;

import lotto.Lottos;
import lotto.WinningStatistic;
import user.BonusNumber;
import user.WinNumber;
import utils.InputUtils;
import user.PurchaseAmount;
import utils.OutputUtils;

import java.util.List;

public class LottoController {

    private PurchaseAmount getLottoPurchaseAmountFromUser() {
        String userInput = InputUtils.getMoneyFromUser();

        return new PurchaseAmount(userInput);
    }

    private Lottos createLottos(PurchaseAmount purchaseAmount) {
        int purchaseCount = purchaseAmount.getPurchaseCount();

        OutputUtils.printLottoPurchaseCount(purchaseCount);

        Lottos lottos = new Lottos(purchaseCount);

        OutputUtils.printPurchasedLottoNumbers(lottos);

        return lottos;
    }

    private WinNumber getWinNumbersFromUser() {
        String userInput = InputUtils.getWinNumbersFromUser();
        return new WinNumber(userInput);
    }

    private BonusNumber getBonusNumberFromUser(List<Integer> winNumber) {
        String userInput = InputUtils.getBonusNumberFromUser();
        return new BonusNumber(userInput, winNumber);
    }

    private WinningStatistic calculateWinningRate(Lottos lottos,
                                                  WinNumber winNumber,
                                                  BonusNumber bonusNumber) {
        return lottos.calculateWinningStatus(winNumber, bonusNumber);
    }

    private void printResult(WinningStatistic winningStat, double profitRate) {
        OutputUtils.printWinningStats(winningStat);
        OutputUtils.printCalculatedProfitRate(profitRate);
    }

    public void start() {
        PurchaseAmount purchaseAmount = getLottoPurchaseAmountFromUser();

        Lottos lottos = createLottos(purchaseAmount);

        WinNumber winNumber = getWinNumbersFromUser();
        BonusNumber bonusNumber = getBonusNumberFromUser(winNumber.getWinNumber());

        WinningStatistic winningStat = calculateWinningRate(lottos, winNumber, bonusNumber);

        printResult(winningStat, winningStat.calculateProfitRate(purchaseAmount));
    }
}
