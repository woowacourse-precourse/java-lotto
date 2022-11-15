package lotto.presentation;

import lotto.application.LottoFacade;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.money.Money;
import lotto.domain.profit.Profit;
import lotto.domain.statistics.Statistics;

public class LottoController {

    private final LottoFacade lottoFacade;

    public LottoController(LottoFacade lottoFacade) {
        this.lottoFacade = lottoFacade;
    }

    public void run() {
        final Money money = lottoFacade.createMoney();
        final Lottos lottos = lottoFacade.buyLottos(money);
        final WinningLotto winningLotto = lottoFacade.createWinningLotto();

        final Statistics statistics = lottoFacade.getStatistics(winningLotto, lottos);
        final Profit profit = lottoFacade.getProfit(money, statistics.getReward());

        lottoFacade.sendWinningStats(statistics, profit);
    }
}
