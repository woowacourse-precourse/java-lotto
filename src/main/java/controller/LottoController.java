package controller;

import camp.nextstep.edu.missionutils.Randoms;
import constants.LottoConstants;
import lotto.Lotto;
import utils.InputUtils;
import user.PurchaseAmount;
import utils.Validator;

import java.util.List;

public class LottoController {

    private PurchaseAmount purchaseAmount;
    private List<Lotto> lottos;

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

    public void start() {
        getLottoPurchaseAmountFromUser();

        int purchaseCount = purchaseAmount.getPurchaseCount();
        while (purchaseCount > 0) {
            generateLotteryNumbers();
            purchaseCount--;
        }
    }
}
