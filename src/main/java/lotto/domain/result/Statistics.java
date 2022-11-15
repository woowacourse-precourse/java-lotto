package lotto.domain.result;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Statistics {
    static final int ZERO_COUNT = 0;
    static final int ONE_COUNT = 1;

    static Map<LottoRank, Integer> result = new TreeMap<>(Collections.reverseOrder());

    public static void initializeResult(Map<LottoRank, Integer> result) {
        for (LottoRank lottoRank : LottoRank.values()) {
            result.put(lottoRank, ZERO_COUNT);
        }
    }

    public static Map<LottoRank, Integer> makeStatistics(List<Integer> winningCount, List<Boolean> bonusMatching) {
        initializeResult(result);

        for (int i = 0; i < winningCount.size(); i++) {
            LottoRank lottoRank = LottoRank.getLottoRankResult(winningCount.get(i), bonusMatching.get(i));

            result.put(lottoRank, result.get(lottoRank) + ONE_COUNT);
        }

        return result;
    }
}
