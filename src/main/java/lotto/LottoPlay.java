package lotto;

import lotto.controller.BuyLottoController;
import lotto.controller.StatisticController;
import lotto.controller.WinningLottoController;
import lotto.domain.Lotto;

import java.io.IOException;
import java.util.List;

public class LottoPlay {
    private final static BuyLottoController buyLotto = new BuyLottoController();
    private final static WinningLottoController inputWinningLotto = new WinningLottoController();
    private final static StatisticController statistic = new StatisticController();

    protected void run() throws IOException {
        List<Lotto> lottoList = buyLotto.runBuyLottoController();
        List<Integer> winningLotto = inputWinningLotto.runWinningLottoController();
        statistic.runStatisticController(lottoList, winningLotto);
    }
}