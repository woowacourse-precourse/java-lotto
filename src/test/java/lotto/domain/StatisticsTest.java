package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsTest {

    @DisplayName("동일한 key(Prize)에 해당하는 값이 입력되었을 경우 value(개수)가 업데이트가 잘 되는지 테스트")
    @Test
    void updateStatistics() {
        //given
        Statistics statistics = new Statistics();
        Prize prize1 = Prize.SECOND;
        Prize prize2 = Prize.SECOND;
        //when
        statistics.updateStatistics(prize1);
        statistics.updateStatistics(prize2);

        //then
        Assertions.assertThat(statistics.getStatisticsResult()
                                        .get(Prize.SECOND))
                  .isEqualTo(2);

    }
}