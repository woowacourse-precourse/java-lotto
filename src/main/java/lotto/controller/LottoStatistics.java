package lotto.controller;

import lotto.model.LottoResult;
import lotto.model.Prize;
import lotto.model.Statistics;
import lotto.model.User;
import lotto.view.LottoStatisticsUI;

import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {
    private final LottoStatisticsUI lottostatisticsUI = new LottoStatisticsUI();

    public void controlLottoResults(User user, LottoResult lottoResult){
        Statistics statistics = new Statistics();
        statistics.setPrizeTable(lottoResult.getResults());
        Map<Prize, Integer> prizeTable = statistics.getPrizeTable();
        lottostatisticsUI.showOverallMatches(prizeTable);

        statistics.setEarnedMoney();
        double rate = statistics.calculateRate(user.getUserPurchaseAmount());
        lottostatisticsUI.showRate(rate);
    }
}
