package lotto.controller;

import lotto.model.LottoResult;
import lotto.model.Statistics;
import lotto.model.User;
import lotto.view.LottoStatisticsUI;

public class LottoStatistics {
    private final LottoStatisticsUI lottostatisticsUI = new LottoStatisticsUI();

    public void controlLottoResults(User user, LottoResult lottoResult){
        Statistics statistics = new Statistics();
        statistics.setPrizeTable(lottoResult.getResults());

    }
}
