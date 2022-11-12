package lotto;

import lotto.domain.LottoStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {

    @DisplayName("결과를 추가하지 않았을 때 모두 0 출력.")
    @Test
    void resultByNeverAdded() {
        LottoStatistics statistics = new LottoStatistics();

        assertThat(statistics.getYield()).isEqualTo(0);
    }
}
