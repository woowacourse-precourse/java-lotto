package lotto.domain.validator;

import lotto.domain.constants.ErrorMessage;
import lotto.domain.constants.LottoRank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RankedCountsValidator {
    private RankedCountsValidator() { }

    public static void validaterankedCounts(Map<LottoRank, Integer> rankedCounts) {
        if (isRanksIllegal(rankedCounts)) {
            throw new IllegalArgumentException(ErrorMessage.RESULT_RANK_ILLEGAL.getValue());
        }
        if (hasNotCounted(rankedCounts)) {
            throw new IllegalArgumentException(ErrorMessage.RESULT_RANK_NOT_COUNTED.getValue());
        }
    }

    private static boolean isRanksIllegal(Map<LottoRank, Integer> rankedCounts) {
        Set<LottoRank> countedRanks = rankedCounts.keySet();
        List<LottoRank> allRanks = Arrays.asList(LottoRank.values());
        if (countedRanks.size() != allRanks.size()) {
            return true;
        }
        return !countedRanks.containsAll(allRanks);
    }

    private static boolean hasNotCounted(Map<LottoRank, Integer> rankedCounts) {
        int rankingsCount = rankedCounts.values()
                .stream()
                .reduce(0, Integer::sum);
        return rankingsCount == 0;
    }
}
