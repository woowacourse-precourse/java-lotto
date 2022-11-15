package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public static final int PRICE_OF_LOTTO = 1000;

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void playLottoGame() {
        int purchasePrice = inputView.userInputPurchasePrice();
        int amountOfLotto = computeAmountOfLotto(purchasePrice);
        outputView.printAmountOfLottoMessage(amountOfLotto);
    }

    public int computeAmountOfLotto(int purchasePrice) {
        return purchasePrice / PRICE_OF_LOTTO;
    }
}
