package lotto.controller;

import lotto.view.LottoView;

public class LottoController {

    private int purchase;

    private LottoController() {
    }

    public static int gameStartAndGetInput() {
        LottoView.printStartMessage();
        String input = LottoView.getLottoPurchaseAmount();

        return 0;
    }
}
