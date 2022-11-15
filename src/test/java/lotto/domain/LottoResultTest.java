package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void set_up() {
        Map<Rank, Long> statics = new HashMap<>();
        statics.put(Rank.FIRST_PRIZE, 1L);
        lottoResult = LottoResult.from(statics);
    }

    @DisplayName("구매 금액을 통해 수익률 계산")
    @Test
    void calculate_yield() {
        double yield = lottoResult.calculateYield(35000);
        assertThat(yield).isEqualTo((((double) 2000000000) * 100) / 35000);
    }

    @DisplayName("로또 통계 순위별 당첨 개수 검증. 당첨이 없으면 0반환")
    @Test
    void get_counts() {
        assertAll(
                () -> assertThat(lottoResult.getStatistics().get(Rank.FIRST_PRIZE)).isEqualTo(1),
                () -> assertThat(lottoResult.getStatistics().get(Rank.SECOND_PRIZE)).isZero()
        );
    }
}
