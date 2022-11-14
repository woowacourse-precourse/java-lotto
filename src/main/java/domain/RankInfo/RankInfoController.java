package domain.RankInfo;

import domain.Bonus.Bonus;
import domain.Lotto.Lotto;
import domain.Money.Money;
import domain.UserLotto.UserLotto;

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
