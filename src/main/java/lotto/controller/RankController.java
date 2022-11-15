package lotto.controller;

import lotto.domain.rank.Rank;
import lotto.domain.lotto.WinLotto;
import lotto.domain.user.User;
import lotto.service.RankService;
import lotto.view.RankingView;

public class RankController {

    private final RankService rankService;

    public RankController(RankService rankService) {
        this.rankService = rankService;
    }

    public RankingView statistics(User user, String winningNumbers, String bonus){
        WinLotto winLotto = rankService.generateWinningLotto(winningNumbers, bonus);
        Rank ranking = rankService.calculateRanking(user, winLotto);
        double profit = rankService.calculateProfit(user, ranking);
        return new RankingView(ranking, profit);
    }
}
