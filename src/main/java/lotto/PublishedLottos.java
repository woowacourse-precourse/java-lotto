package lotto;

import lotto.type.Rank;

import java.util.ArrayList;
import java.util.List;

public class PublishedLottos {
    private static final int RANK_TWO_OR_THREE_COUNT = 5;
    private final Lotto winningLotto;
    private final List<Lotto> publishedLottos;

    public PublishedLottos(Lotto winningLotto, List<Lotto> publishedLottos) {
        this.winningLotto = winningLotto;
        this.publishedLottos = publishedLottos;
    }

    public List<Rank> calculateResultRanks(Integer bonusNumber) {
        List<Rank> ranks = new ArrayList<>();

        for (Lotto publishedLotto : this.publishedLottos) {
            ranks.add(calculateLottoRank(winningLotto, publishedLotto, bonusNumber));
        }

        return ranks;
    }

    private Rank calculateLottoRank(Lotto winningLotto, Lotto playerLotto, Integer bonusNumber) {
        Rank rank;
        int correctCount = winningLotto.compare(playerLotto);

        if (correctCount == RANK_TWO_OR_THREE_COUNT) {
            return Rank.getRank(correctCount, playerLotto.hasBonusNumber(bonusNumber));
        }
        rank = Rank.getRank(correctCount, false);

        return rank;
    }

    public boolean isWinningLottoContainBonusNumber(Integer bonusNumber) {
        return winningLotto.hasBonusNumber(bonusNumber);
    }
}
