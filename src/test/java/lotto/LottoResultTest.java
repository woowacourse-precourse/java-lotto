package lotto;

import lotto.enums.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;

import static lotto.enums.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @DisplayName("구입금액 대비 상금의 수익률을 구한다.")
    @Test
    void calculateEarningRatio() {
        //given
        EnumMap<Rank, Integer> ranks = new EnumMap<>(Rank.class);
        ranks.put(RANK_FOUR, 2);  // 상금 100_000
        ranks.put(RANK_TWO, 1);   // 상금 30_000_000
        LottoResult result = new LottoResult(ranks);

        //when
        float buyPrice1 = 3_000;
        float buyPrice2 = 10_000;
        float buyPrice3 = 30_101_000;

        //then
        assertThat(result.calculateEarningRatio(3_000)).isEqualTo(100 * (30_100_000 / buyPrice1));
        assertThat(result.calculateEarningRatio(10_000)).isEqualTo(100 * (30_100_000 / buyPrice2));
        assertThat(result.calculateEarningRatio(30_101_000)).isEqualTo(100 * (30_100_000 / buyPrice3));
    }
}