package lotto;

import lotto.enums.Rank;

import java.util.EnumMap;
import java.util.List;

public class LottoGame {
    private final Integer bonusNumber;
    private final PublishedLottos publishedLottos;

    public LottoGame(Integer bonusNumber, Lotto winningLotto, List<Lotto> goingToPublishLottos) {
        this.bonusNumber = bonusNumber;
        this.publishedLottos = new PublishedLottos(winningLotto, goingToPublishLottos);
        this.validateBonusNumber(bonusNumber);
    }

    public LottoResult generateResult() {
        List<Rank> ranks = publishedLottos.calculateResultRanks(bonusNumber);
        EnumMap<Rank, Integer> ranksResult = new EnumMap<>(Rank.class);

        for (Rank rank :ranks) {
            ranksResult.put(rank, ranksResult.getOrDefault(rank,0) + 1);
        }

        return new LottoResult(ranksResult);
    }

    private void validateBonusNumber(Integer bonusNumber) throws IllegalArgumentException {
        if (publishedLottos.isWinningLottoContainBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호와 당첨 번호는 중복되지 않아야 합니다.");
        }
    }
}
