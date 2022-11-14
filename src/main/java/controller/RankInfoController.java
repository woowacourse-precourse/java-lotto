package controller;

import domain.*;
import service.RankInfoService;

public class RankInfoController {
    private final RankInfoService rankInfoService = new RankInfoService();

    public RankInfo createRankInfo() {
        return rankInfoService.createRankInfo();
    }

    public RankInfo getRankInfo(RankInfo rankInfo, Lotto lotto, UserLotto userLotto, Bonus bonus) {
        return rankInfoService.putRankInfo(rankInfo, lotto, userLotto, bonus);
    }

    public String getYield(RankInfo rankInfo, Money money) {
        return String.format("%.1f", rankInfoService.calcYield(rankInfo, money));
    }
}
