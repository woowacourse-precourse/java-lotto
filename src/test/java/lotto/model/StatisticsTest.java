package lotto.model;

import lotto.model.statistics.Statistics;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class StatisticsTest {

    @Test
    @DisplayName("수익률 계산 실패")
    void case1() {
        //given
        BigDecimal money = BigDecimal.ZERO;
        Statistics statistics = new Statistics();
        //when
        //then
        Assertions.assertThatThrownBy(() -> statistics.calculateYield(money)).isInstanceOf(IllegalArgumentException.class);

    }
}
