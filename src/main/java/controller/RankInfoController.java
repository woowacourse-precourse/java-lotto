package controller;

import domain.Bonus;
import domain.Lotto;
import domain.RankInfo;
import domain.UserLotto;
import service.RankInfoService;

public class RankInfoController {
    private final RankInfoService rankInfoService = new RankInfoService();

    public RankInfo createRankInfo() {
        return rankInfoService.createRankInfo();
    }

    public RankInfo getRankInfo(RankInfo rankInfo, Lotto lotto, UserLotto userLotto, Bonus bonus) {
        return rankInfoService.putRankInfo(rankInfo, lotto, userLotto, bonus);
    }
}
