package lotto;

import lotto.type.Rank;

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

        return new LottoResult(ranks);
    }
}
