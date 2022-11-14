package lotto.controller;

import lotto.domain.rank.Rank;
import lotto.domain.lotto.WinLotto;
import lotto.domain.user.User;
import lotto.service.RankService;
import lotto.view.RankingView;

public class RankController {

    private final RankService rankService;
    private final RankingView rankingView;

    public RankController(RankService rankService, RankingView rankingView) {
        this.rankService = rankService;
        this.rankingView = rankingView;
    }

    public String statistics(User user, String winningNumbers, String bonus){
        WinLotto winLotto = rankService.generateWinningLotto(winningNumbers, bonus);
        Rank ranking = rankService.calculateRanking(user, winLotto);
        double profit = rankService.calculateProfit(user, ranking);
        return rankingView.statistics(ranking, profit);
    }
}
