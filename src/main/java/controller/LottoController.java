package controller;

import camp.nextstep.edu.missionutils.Randoms;
import constants.LottoConstants;
import lotto.Lotto;
import utils.InputUtils;
import user.PurchaseAmount;
import utils.OutputUtils;
import utils.Validator;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private PurchaseAmount purchaseAmount;
    private List<Lotto> lottos;

    public LottoController() {
        lottos = new ArrayList<>();
    }

    private void generateLotteryNumbers() {
        List<Integer> lotteryNumbers = Randoms.pickUniqueNumbersInRange(
                LottoConstants.MIN_LOTTO_VALUE,
                LottoConstants.MAX_LOTTO_VALUE,
                LottoConstants.LOTTO_NUM);

        lottos.add(new Lotto(lotteryNumbers));
    }

    private void getLottoPurchaseAmountFromUser() {
        String userInput = InputUtils.getMoneyFromUser();

        Validator.checkLottoPurchaseAmountIsValid(userInput);

        purchaseAmount = new PurchaseAmount(Integer.parseInt(userInput));
    }

    private void printPurchasedLottoNumbers() {
        OutputUtils.printLottoPurchaseCount(purchaseAmount.getPurchaseCount());
        OutputUtils.printPurchasedLottoNumbers(lottos);
    }

    public void start() {
        getLottoPurchaseAmountFromUser();

        int purchaseCount = purchaseAmount.getPurchaseCount();
        while (purchaseCount > 0) {
            generateLotteryNumbers();
            purchaseCount--;
        }

        printPurchasedLottoNumbers();
    }
}
