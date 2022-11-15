package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoResultTest {
    @DisplayName("수익률을 계산한다.")
    @Test
    void lottoCount() {
        //given
        Map<LottoRank, Integer> rankResult = new TreeMap<>();
        LottoRank rank1 = LottoRank.matchRank(3, true);
        LottoRank rank2 = LottoRank.matchRank(4, false);
        rankResult.put(rank1, 1);
        rankResult.put(rank2, 1);

        //when
        LottoResult lottoResult = new LottoResult(rankResult);

        //then
        assertThat(lottoResult.getYield()).isEqualTo(2750.0);
    }
}
