package lotto.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class LottoResults {

    private static final Map<LottoRanking, Integer> lottoResults = new LinkedHashMap<>();

    static {
        Arrays.stream(LottoRanking.values())
                .forEachOrdered(lottoRanking ->
                        lottoResults.put(lottoRanking, 0));
    }
}
