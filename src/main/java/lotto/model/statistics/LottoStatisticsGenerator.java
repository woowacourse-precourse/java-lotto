package lotto.model.statistics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatisticsGenerator {
    public LottoStatistics generate(List<LottoResult> results) {
        Map<LottoResult, Integer> resultMap = new HashMap<>();

        if(results == null) {
            return new LottoStatistics(resultMap);
        }

        for(LottoResult result: results) {
            int resultCount = resultMap.getOrDefault(result, 0) + 1;
            resultMap.put(result, resultCount);
        }
        return new LottoStatistics(resultMap);
    }
}
