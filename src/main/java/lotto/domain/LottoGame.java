package lotto.domain;

import lotto.view.InputView;

public class LottoGame {
    private static int purchaseAmount;

    public void start() {
        String input = InputView.inputPurchaseAmount();

        InputView.isNumber(input);

        purchaseAmount = Integer.parseInt(input);
        InputView.isValidUnit(purchaseAmount);
    }
}
