package lotto.domain.statistic;

import lotto.domain.lotto.Lotto;
import lotto.domain.player.Lottos;
import lotto.domain.player.Player;
import lotto.domain.winner.LottoWinner;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Result {
    private LottoWinner winner;
    private List<Lotto> lottos;
    private Player player;

    public Result(LottoWinner winner, Lottos lottos, Player player) {
        this.winner = winner;
        this.lottos = lottos.getLottos();
        this.player = player;
    }

    public void getCorrectCount() {
        for (Lotto lotto : lottos) {
            Rank rank = getRank(lotto);
            player.addRank(rank);
        }
    }

    public Rank getRank(Lotto lotto) {
        boolean hasBonusNumber = isContainsBonusNumber(lotto);
        long correctCount = getCorrectCount(lotto);
        return Rank.getRank(correctCount, hasBonusNumber);
    }

    private boolean isContainsBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(winner.getBonusNumber());
    }

    private long getCorrectCount(Lotto lotto) {
        List<Integer> lottoNumbers = getWithoutBonusNumber(lotto);
        return lottoNumbers.stream()
                .filter(winner.getLotto().getNumbers()::contains)
                .count();
    }

    private List<Integer> getWithoutBonusNumber(Lotto lotto) {
        return lotto.getNumbers()
                .stream()
                .filter(l -> !Objects.equals(l, winner.getBonusNumber()))
                .collect(Collectors.toList());
    }
}
