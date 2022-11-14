package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoInfo;
import lotto.view.ResultPrint;
import lotto.view.UserInputHelper;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchase {
    private UserInputHelper userInputHelper;
    private ResultPrint resultPrint;

    public LottoPurchase() {
        userInputHelper = new UserInputHelper();
        resultPrint = new ResultPrint();
    }

    public List<Lotto> purchaseLottos() {
        List<Lotto> lottos = new ArrayList<>();
        int purchaseOfNumber = purchaseAmountDividedByLottoPrice(getPurchaseAmountInput());

        for (int count = 0; count < purchaseOfNumber; count++) {
            lottos.add(Lotto.generator());
        }

        resultPrint.generateLotto(lottos);
        return lottos;
    }

    private int getPurchaseAmountInput() {
        userInputHelper.lottoPurchaseHelper();
        String userInput = Console.readLine();
        int purchaseAmount = userInputIsNumber(userInput);
        lottoPriceUnitsValidate(purchaseAmount);
        return purchaseAmount;
    }

    private int purchaseAmountDividedByLottoPrice(int purchaseAmount) {
        lottoPriceUnitsValidate(purchaseAmount);
        int numberOfPurchase = purchaseAmount / LottoInfo.LOTTO_PRICE.getValue();
        resultPrint.numberOfPurchase(numberOfPurchase);
        return numberOfPurchase;
    }

    private int userInputIsNumber(String userInput) {
        if (!userInput.matches("[0-9]*")) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자만 입력할수 있습니다.");
        }

        return Integer.valueOf(userInput);
    }

    private void lottoPriceUnitsValidate(int purchaseAmount) {
        if (purchaseAmount % LottoInfo.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 " + LottoInfo.LOTTO_PRICE.getValue() + "원 단위로 입력 가능합니다.");
        }
    }
}
