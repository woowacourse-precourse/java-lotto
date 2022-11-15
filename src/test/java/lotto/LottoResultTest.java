package lotto;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {
    @Test
    void 로또_결과_기록_테스트() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.insertResult(Rank.FIRST);
        lottoResult.insertResult(Rank.FIRST);
        lottoResult.insertResult(Rank.SECOND);

        Map<Rank, Integer> compareMap = new HashMap<>();
        compareMap.put(Rank.FIRST, 2);
        compareMap.put(Rank.SECOND, 1);

        Map<Rank, Integer> lottoMap = lottoResult.getCopyResult();
        assertThat(lottoMap.size()).isEqualTo(compareMap.size());
        for (Rank rank : lottoMap.keySet()) {
            assertThat(lottoMap.get(rank)).isEqualTo(compareMap.get(rank));
        }
    }
}