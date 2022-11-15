package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class StatisticsTest {
    private Map<Prize, Integer> prizeCntMap;

    @BeforeEach
    void setUp() {
        prizeCntMap = new EnumMap<>(Prize.class);
        prizeCntMap.put(Prize.first, 1);
        prizeCntMap.put(Prize.second, 1);
        prizeCntMap.put(Prize.third, 1);
        prizeCntMap.put(Prize.fourth, 1);
        prizeCntMap.put(Prize.fifth, 1);
    }

    @DisplayName("총합계산기능을 확인한다.")
    @Test
    void checkCalculateTotal() {
        Statistics statistics = new Statistics(prizeCntMap);
        assertThat(statistics.getTotal()).isEqualTo(2031555000);
    }
}