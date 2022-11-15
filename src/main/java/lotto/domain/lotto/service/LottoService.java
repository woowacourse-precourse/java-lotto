package lotto.domain.lotto.service;

import lotto.domain.lotto.BonusBall;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.money.Money;
import lotto.domain.profit.Profit;
import lotto.domain.statistics.Statistics;

public interface LottoService {
    String requestMoney();

    Lottos buyLottos(Money money);

    void sendLottosInfo(Lottos lottos);

    Lotto requestWinningNumbers();

    BonusBall requestBonusNumber();

    void sendStatistics(Statistics statistics);

    void sendProfit(Profit profit);
}
