package lotto.controller;

import lotto.view.InputView;

public class LottoSystem {
    private static final InputView inputview = new InputView();
    private static final int LOTTO_PRICE = 1000;

    private int LottoQuantityCalculation() {
        int userMoney = Integer.parseInt(inputview.inputUserMoney());
        return userMoney / LOTTO_PRICE;
    }
}
