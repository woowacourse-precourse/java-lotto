package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
        assertThat(statistics.getStatisticsResult()
                                        .get(Prize.SECOND))
                  .isEqualTo(2);
    }

    @DisplayName("총 당첨 수령 금액과 사용자가 구매에 지불한 금액을 계산해 수익률이 잘 반환 되는지 테스트")
    @Test
    void calculateYield() {
        //given
        Amount amount = new Amount(8000);
        Statistics statistics = new Statistics();
        Prize prize = Prize.SECOND;

        //when
        statistics.updateStatistics(prize);
        float yield = statistics.calculateYiled(amount);
        //then
        assertThat(yield).isEqualTo(375000);
    }
}