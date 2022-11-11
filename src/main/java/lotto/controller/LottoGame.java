package lotto.controller;

import lotto.view.InputView;

public class LottoGame {
    private int getLottoPurchaseAmount() {
        int quantity = InputView.getLottoPurchaseAmount() / 1000;
        return quantity;
    }
}
