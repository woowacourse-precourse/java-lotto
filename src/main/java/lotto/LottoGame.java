package lotto;

import lotto.type.Rank;

import java.util.EnumMap;
import java.util.List;

public class LottoGame {
    private final Integer bonusNumber;
    private final PublishedLottos publishedLottos;

    public LottoGame(Integer bonusNumber, Lotto winningLotto, List<Lotto> goingToPublishLottos) {
        this.bonusNumber = bonusNumber;
        this.publishedLottos = new PublishedLottos(winningLotto, goingToPublishLottos);
    }

    public LottoResult play() {
        List<Rank> ranks = publishedLottos.calculateResultRanks(bonusNumber);
        EnumMap<Rank, Integer> ranksResult = new EnumMap<>(Rank.class);

        for (Rank rank :ranks) {
            ranksResult.put(rank, ranksResult.getOrDefault(rank,0) + 1);
        }

        return new LottoResult(ranksResult);
    }
}
