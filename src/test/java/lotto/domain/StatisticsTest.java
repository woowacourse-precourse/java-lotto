package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsTest {
    @DisplayName("수익률을 계산한다1")
    @Test
    void calculateRateOfReturn() {
        Statistics statistics = new Statistics(10000, 0, 1, 2, 0, 1);
        assertEquals("330050.0", String.format("%.1f", statistics.rateOfReturn));
    }

    @DisplayName("수익률을 계산한다2")
    @Test
    void calculateRateOfReturn_2() {
        Statistics statistics = new Statistics(103000, 0, 0, 0, 0, 3);
        assertEquals("14.6", String.format("%.1f", statistics.rateOfReturn));
    }

}