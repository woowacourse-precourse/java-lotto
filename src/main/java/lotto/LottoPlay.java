package lotto;

import lotto.controller.BuyLottoController;
import lotto.controller.WinningLottoController;
import lotto.domain.Lotto;

import java.io.IOException;
import java.util.List;

public class LottoPlay {
    private final static BuyLottoController buyLotto = new BuyLottoController();
    private final static WinningLottoController inputWinningLotto = new WinningLottoController();

    public void run() throws IOException {
        List<Lotto> lottoList = buyLotto.runBuyLottoController();
        inputWinningLotto.runWinningLottoController(lottoList);
    }
}
