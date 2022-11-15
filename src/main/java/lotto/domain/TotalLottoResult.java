package lotto.domain;

import lotto.domain.constants.LottoRank;
import lotto.domain.validator.RankedCountsValidator;

import java.util.Map;

public class TotalLottoResult {
    private final Map<LottoRank, Integer> rankedCounts;

    public TotalLottoResult(Map<LottoRank, Integer> rankedCounts) throws IllegalArgumentException {
        RankedCountsValidator.validaterankedCounts(rankedCounts);
        this.rankedCounts = rankedCounts;
    }

    public int getCountByRank(LottoRank lottoRank) {
        return rankedCounts.get(lottoRank);
    }

    public int addUpTotalPrizeAmount() {
        return rankedCounts.keySet()
                .stream()
                .map(this::calculatePrizeByCountedRank)
                .reduce(0, Integer::sum);
    }

    private int calculatePrizeByCountedRank(LottoRank countedRank) {
        int count = rankedCounts.get(countedRank);
        int prize = countedRank.getPrize();
        return count * prize;
    }
}
