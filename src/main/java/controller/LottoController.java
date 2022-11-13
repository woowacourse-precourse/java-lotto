package controller;

import camp.nextstep.edu.missionutils.Randoms;
import constants.LottoConstants;
import lotto.Lotto;
import lotto.Wins;
import utils.InputUtils;
import user.PurchaseAmount;
import utils.OutputUtils;
import utils.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    private List<Lotto> lottos;
    private List<Integer> winNumbers;
    private int bonusNumber;

    public LottoController() {
        lottos = new ArrayList<>();
        winNumbers = new ArrayList<>();
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
        printPurchasedLottoNumbers();
    }

    private void printPurchasedLottoNumbers() {
        OutputUtils.printPurchasedLottoNumbers(lottos);
    }

    private void getWinNumbersFromUser() {
        String userInput = InputUtils.getWinNumbersFromUser();
        Validator.checkWinsNumberIsValid(userInput);

        winNumbers = Arrays.stream(userInput.split(LottoConstants.SEPARATOR))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private void getBonusNumberFromUser() {
        String userInput = InputUtils.getBonusNumberFromUser();
        Validator.checkBonusNumberIsValid(userInput, winNumbers);

        bonusNumber = Integer.parseInt(userInput);
    }

    private String calculateWinningRate() {
        for (Lotto lotto : lottos) {
            lotto.countMatchingNumber(winNumbers, bonusNumber);
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
            getWinNumbersFromUser();
            getBonusNumberFromUser();
        } catch (IllegalArgumentException e) {
            OutputUtils.printException(e);
            return;
        }

        String winningStats = calculateWinningRate();
        double profitRate = calculateProfitRate(purchaseAmount);

        printResult(winningStats, profitRate);
    }
}
