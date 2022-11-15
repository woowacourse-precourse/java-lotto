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

    public void lottoRankingService() {
        setPlayerLottosRanking();
        setPlayerEarningRate();
        printRankingResult();
    }

    public void setPlayerLottosRanking() {
        List<Lotto> lottos = player.getLottos();
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumber = lotto.getLottoNumbers();
            int rank = this.rank.countWinningNumber(lottoNumber, player.getWinningNumber());
            boolean isBonusContain = this.rank.isBonusBallContain(lottoNumber, player.getBonusNumber());
            RankType rankType = RankType.setRankType(rank, isBonusContain);
            this.rank.setRank(rankType);
        }
    }

    public void setPlayerEarningRate() {
        this.rank.setEarningRate(player.getMoney());
    }

    public void printRankingResult() {
        OutputView.printWinningStatistics();
        OutputView.printRanking(rank.getRank());
        OutputView.printEarningRate(rank.getEarningRate());
    }
}