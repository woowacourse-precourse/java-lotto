package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("당첨 통계 기능 테스트")
class StatisticTest {

    @BeforeEach
    void initCounts() {
        Statistic.initStatistic();
    }

    @DisplayName("당첨 내역 횟수가 정상적으로 증가하는지 확인한다.")
    @Test
    void checkSetCount() {
        int testMatchingCount = 3;
        boolean testBonus = true;
        Statistic.setCounts(testMatchingCount, testBonus);

        testMatchingCount = 5;
        Statistic.setCounts(testMatchingCount, testBonus);

        assertThat(Statistic.FIFTH_PLACE.getCount()).isEqualTo(1);
        assertThat(Statistic.FOURTH_PLACE.getCount()).isEqualTo(0);
        assertThat(Statistic.THIRD_PLACE.getCount()).isEqualTo(0);
        assertThat(Statistic.SECOND_PLACE.getCount()).isEqualTo(1);
        assertThat(Statistic.FIRST_PLACE.getCount()).isEqualTo(0);
    }

    @DisplayName("총 당첨 상금이 정상적으로 계산되는지 확인한다.")
    @Test
    void checkGetTotalPrize() {
        Statistic.FIFTH_PLACE.addCount();
        Statistic.FOURTH_PLACE.addCount();

        assertThat(Statistic.getTotalPrize()).isEqualTo(55000);
    }
}
