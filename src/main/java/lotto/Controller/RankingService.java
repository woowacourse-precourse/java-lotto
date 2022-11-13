package lotto.Controller;

import lotto.Domain.Lotto;
import lotto.Domain.Player;
import lotto.Domain.Rank;
import lotto.View.OutputView;
import lotto.type.RankType;

import java.util.List;

public class RankingService {
    private Rank rank;
    private Player player;

    public RankingService(Rank rank, Player player) {
        this.rank = rank;
        this.player = player;
    }

    public void getRanking() {
        List<Lotto> lottos = player.getLottos();
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumber = lotto.getLottoNumbers();
            int rank = this.rank.countWinningNumber(lottoNumber, player.getPlayerLotto());
            boolean isBonusContain = this.rank.isBonusBallContain(lottoNumber, player.getPlayerBonusNumber());
            RankType rankType = RankType.setRankType(rank, isBonusContain);
            this.rank.setRank(rankType);
        }
    }

    public void getEarningRate() {
        this.rank.setEarningRate(player.getMoney());
    }

}