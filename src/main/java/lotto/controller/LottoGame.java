package lotto.controller;

import lotto.domain.LottoCount;
import lotto.view.Input;

public class LottoGame {
    String purchaseAmount;
    Input input = new Input();

    public void start() {
        LottoCount lottoCount = new LottoCount(input.lottoPurchaseAmount());
        input.lottoWinningNumbers();

        input.lottoBonusNumber();
    }
}
