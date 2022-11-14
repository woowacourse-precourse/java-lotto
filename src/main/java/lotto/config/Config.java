package lotto.config;

import lotto.service.DefaultLottoIssueService;
import lotto.service.LottoIssueService;

public class Config {

    public LottoIssueService lottoIssueService() {
        return new DefaultLottoIssueService();
    }

}
