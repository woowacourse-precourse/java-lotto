package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsTest {
    @DisplayName("당첨금이 0원일 때 수익률 0을 반환한다.")
    @Test
    void 수익률_계산_정확성_테스트() {
        Statistics statistics = new Statistics();
        statistics.record(2, true);
        statistics.record(1, true);

        assertThat(statistics.getYield(5)).isEqualTo(0);
    }
}
