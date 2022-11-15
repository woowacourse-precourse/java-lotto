package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ProfitTest {
    Profit p;

    @BeforeEach
    void setUp() {
        p = new Profit();
    }

    @DisplayName("수익률 계산 케이스1")
    @Test
    void case1() {
        List<Integer> winningPrices = List.of(5000, 5000, 5000, 0, 0);

        assertThat(p.calProfitRate(winningPrices, 2)).isEqualTo(300.0);
    }

    @DisplayName("수익률 계산 케이스2")
    @Test
    void case2() {
        List<Integer> winningPrices = List.of(5000, 0, 0, 0, 0, 0, 0, 0);

        assertThat(p.calProfitRate(winningPrices, 2)).isEqualTo(62.5);
    }


    @DisplayName("수익률 계산 케이스3")
    @Test
    void case3() {
        List<Integer> winningPrices = List.of(0, 0, 0, 0, 2000000000);

        assertThat(p.calProfitRate(winningPrices, 2)).isEqualTo(40000000.0);
    }

    @DisplayName("수익률 계산 케이스4")
    @Test
    void case4() {
        List<Integer> winningPrices = List.of(0, 0, 0, 30000000, 2000000000);

        assertThat(p.calProfitRate(winningPrices, 2)).isEqualTo(40600000.0);
    }
}