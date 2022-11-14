package lotto.controller;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinLotto;
import lotto.domain.user.User;
import lotto.service.RankService;
import lotto.view.Rank;

import java.util.List;

public class RankController {

    private final RankService rankService;
    private final Rank rank;

    public RankController(RankService rankService, Rank rank) {
        this.rankService = rankService;
        this.rank = rank;
    }

    public String statistics(User user, String winningNumbers, String bonus){
        WinLotto winLotto = rankService.generateWinningLotto(winningNumbers, bonus);
        List<Integer> ranking = rankService.calculateRanking(user, winLotto);
        return rank.statistics(ranking);
    }
}
