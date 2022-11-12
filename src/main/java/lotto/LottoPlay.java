package lotto;

import lotto.controller.BuyLottoController;
import lotto.controller.WinningLottoController;

import java.io.IOException;

public class LottoPlay {
    private final static BuyLottoController buyLotto = new BuyLottoController();
    private final static WinningLottoController inputWinningLotto = new WinningLottoController();

    public void run() throws IOException {
        buyLotto.runBuyLottoController();
    }
}
