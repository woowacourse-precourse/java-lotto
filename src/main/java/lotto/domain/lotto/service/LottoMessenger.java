package lotto.domain.lotto.service;

import lotto.domain.lotto.Lottos;
import lotto.domain.profit.Profit;
import lotto.domain.statistics.Statistics;

public interface LottoMessenger {

    String requestMoney();

    void sendLottosInfo(Lottos lottos);

    String requestWinningNumbers();

    String requestBonusNumber();

    void sendStatistics(Statistics statistics);

    void sendProfit(Profit profit);
}
