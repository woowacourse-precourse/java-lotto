package lotto.controller;

import lotto.Input;

public class LottoGame {
    Input input = new Input();

    public void start() {
        input.lottoPurchaseAmount();

        input.lottoWinningNumbers();

        input.lottoBonusNumber();
    }
}
