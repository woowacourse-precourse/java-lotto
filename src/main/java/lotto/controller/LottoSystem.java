package lotto.controller;

import lotto.view.InputView;

public class LottoSystem {

    private static final InputView inputView = new InputView();

    public LottoSystem() {}

    public void start() {
        String userPrice = inputView.inputPrice();
    }
}