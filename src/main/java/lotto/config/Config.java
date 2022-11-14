package lotto.config;

import lotto.service.DefaultLottoIssueService;
import lotto.service.DefaultStatisticsService;
import lotto.service.LottoIssueService;
import lotto.service.StatisticsService;

public class Config {

    public LottoIssueService lottoIssueService() {
        return new DefaultLottoIssueService();
    }

    public StatisticsService statisticsService() {
        return new DefaultStatisticsService();
    }

}
