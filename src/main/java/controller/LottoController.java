package controller;

import lotto.Lotto;
import lotto.Lottos;
import lotto.Wins;
import user.BonusNumber;
import user.WinNumber;
import utils.InputUtils;
import user.PurchaseAmount;
import utils.OutputUtils;

import java.util.List;

public class LottoController {

    private PurchaseAmount getLottoPurchaseAmountFromUser() {
        try {
            String userInput = InputUtils.getMoneyFromUser();

            return new PurchaseAmount(userInput);
        } catch (IllegalArgumentException e) {
            OutputUtils.printException(e);
            return getLottoPurchaseAmountFromUser();
        }
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

    private String calculateWinningRate(Lottos lottos, WinNumber winNumber, BonusNumber bonusNumber) {
        for (Lotto lotto : lottos.getLottos()) {
            lotto.countMatchingNumber(winNumber.getWinNumber(), bonusNumber.getBonusNumber());
        }
        return Wins.getWinningStats();
    }

    private double calculateProfitRate(PurchaseAmount purchaseAmount) {
        return Wins.getProfitRate(purchaseAmount.getPurchaseAmount());
    }

    private void printResult(String winningStats, double profitRate) {
        OutputUtils.printWinningStats(winningStats);
        OutputUtils.printCalculatedProfitRate(profitRate);
    }

    public void start() {
        PurchaseAmount purchaseAmount = getLottoPurchaseAmountFromUser();

        Lottos lottos = createLottos(purchaseAmount);

        try {
            WinNumber winNumber = getWinNumbersFromUser();
            BonusNumber bonusNumber = getBonusNumberFromUser(winNumber.getWinNumber());

            String winningStats = calculateWinningRate(lottos, winNumber, bonusNumber);
            double profitRate = calculateProfitRate(purchaseAmount);

            printResult(winningStats, profitRate);
        } catch (IllegalArgumentException e) {
            OutputUtils.printException(e);
        }
    }
}
