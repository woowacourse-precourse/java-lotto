package lotto.domain;

import lotto.domain.constants.LottoRank;
import lotto.domain.validator.LottoNumbersValidator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoDraw {
    private final Lotto drawnLotto;
    private final int bonusNumber;

    public LottoDraw(Lotto drawnLotto, int bonusNumber) throws IllegalArgumentException {
        LottoNumbersValidator.validateLottoDrawNumbers(drawnLotto, bonusNumber);
        this.drawnLotto = drawnLotto;
        this.bonusNumber = bonusNumber;
    }

    public Map<LottoRank, Integer> sumUpRankedCounts(List<Lotto> purchasedLottos) {
        Map<LottoRank, Integer> rankedCounts = initializeRankedCounts();
        purchasedLottos.stream()
                .map(this::calculateRankingByPurchasedLotto)
                .forEach(ranking -> addOneToRankedCounts(rankedCounts, ranking));
        return rankedCounts;
    }

    private Map<LottoRank, Integer> initializeRankedCounts() {
        Map<LottoRank, Integer> rankedCounts = new HashMap<>();
        Arrays.stream(LottoRank.values())
                .forEach(rankValue -> rankedCounts.put(rankValue, 0));
        return rankedCounts;
    }

    private void addOneToRankedCounts(Map<LottoRank, Integer> rankedCounts, LottoRank ranking) {
        int count = rankedCounts.getOrDefault(ranking, 0) + 1;
        rankedCounts.put(ranking, count);
    }

    private LottoRank calculateRankingByPurchasedLotto(Lotto purchasedLotto) {
        int matchCount = drawnLotto.countMatchingNumbers(purchasedLotto);
        boolean containsBonusNumber = purchasedLotto.containsThisNumber(bonusNumber);
        for (LottoRank rank : LottoRank.values()) {
            if (isRightRanking(rank, matchCount, containsBonusNumber)) {
                return rank;
            }
        }
        return LottoRank.RANK_LOSE;
    }

    private boolean isRightRanking(LottoRank rank, int matchCount, boolean containsBonusNumber) {
        if (rank.hasSameMatchCount(matchCount) && rank.isRequiredToCheckBonus()) {
            return containsBonusNumber;
        }
        return rank.hasSameMatchCount(matchCount);
    }
}
