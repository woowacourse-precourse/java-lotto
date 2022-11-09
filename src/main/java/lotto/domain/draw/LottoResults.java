package lotto.domain.draw;

import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LottoResults {

    private static final Map<LottoRanking, Integer> lottoResults = new LinkedHashMap<>();

    static {
        EnumSet.allOf(LottoRanking.class)  // 이 또한 자바독이 순서 보장. 하지만 쓰레드 안전하지 않음..
                .forEach(lottoRanking -> lottoResults.put(lottoRanking, 0));
    }

    // 테스트용 메서드
    Set<LottoRanking> keySet() {  // 순서대로 들어간걸 어떻게 확인하지 ?? 자바독이 보장한다고 함.
        return lottoResults.keySet();
    }
}
