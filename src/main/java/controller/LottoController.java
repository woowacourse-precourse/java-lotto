package controller;

import camp.nextstep.edu.missionutils.Randoms;
import constants.LottoConstants;
import lotto.Lotto;
import lotto.Wins;
import user.BonusNumber;
import user.WinNumber;
import utils.InputUtils;
import user.PurchaseAmount;
import utils.OutputUtils;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private List<Lotto> lottos;

    public LottoController() {
        lottos = new ArrayList<>();
    }

    private PurchaseAmount getLottoPurchaseAmountFromUser() {
        try {
            String userInput = InputUtils.getMoneyFromUser();

            return new PurchaseAmount(userInput);
        } catch (IllegalArgumentException e) {
            OutputUtils.printException(e);
            return getLottoPurchaseAmountFromUser();
        }
    }

    private void generateLotteryNumbers(PurchaseAmount purchaseAmount) {
        int purchaseCount = purchaseAmount.getPurchaseCount();
        OutputUtils.printLottoPurchaseCount(purchaseCount);

        while (purchaseCount > 0) {
            List<Integer> lotteryNumbers = Randoms.pickUniqueNumbersInRange(
                    LottoConstants.MIN_LOTTO_VALUE,
                    LottoConstants.MAX_LOTTO_VALUE,
                    LottoConstants.LOTTO_NUM);

            lottos.add(new Lotto(lotteryNumbers));
            purchaseCount--;
        }
        OutputUtils.printPurchasedLottoNumbers(lottos);
    }

    private WinNumber getWinNumbersFromUser() {
        String userInput = InputUtils.getWinNumbersFromUser();
        return new WinNumber(userInput);
    }

    private BonusNumber getBonusNumberFromUser(List<Integer> winNumber) {
        String userInput = InputUtils.getBonusNumberFromUser();
        return new BonusNumber(userInput, winNumber);
    }

    private String calculateWinningRate(WinNumber winNumbers, BonusNumber bonusNumber) {
        for (Lotto lotto : lottos) {
            lotto.countMatchingNumber(winNumbers.getWinNumber(), bonusNumber.getBonusNumber());
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

        generateLotteryNumbers(purchaseAmount);

        try {
            WinNumber winNumber = getWinNumbersFromUser();
            BonusNumber bonusNumber = getBonusNumberFromUser(winNumber.getWinNumber());

            String winningStats = calculateWinningRate(winNumber, bonusNumber);
            double profitRate = calculateProfitRate(purchaseAmount);

            printResult(winningStats, profitRate);
        } catch (IllegalArgumentException e) {
            OutputUtils.printException(e);
        }
    }
}
