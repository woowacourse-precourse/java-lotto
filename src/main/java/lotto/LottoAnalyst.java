package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoAnalyst {

    public Map<LottoGrade, Integer> analyze(List<LottoGrade> lottoResults) {
        Map<LottoGrade, Integer> lottoMatchMap = new EnumMap<>(LottoGrade.class);
        for(LottoGrade lottoGrade : LottoGrade.values()) {
            lottoMatchMap.put(lottoGrade, 0);
        }
        lottoResults.forEach(
            lottoResult -> lottoMatchMap.put(lottoResult, lottoMatchMap.get(lottoResult) + 1)
        );

        return lottoMatchMap;
    }
}
