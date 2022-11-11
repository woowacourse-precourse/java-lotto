package lotto;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    void 로또_개수_테스트() {
        Calculator calculator = new Calculator();
        int count = calculator.getLottoCount(14000);

        assertThat(count).isEqualTo(14);
    }

    @Test
    void 수익률_계산_테스트() {
        Calculator calculator = new Calculator();
        Map<Rank, Integer> map = new HashMap<>();
        map.put(Rank.FIFTH, 1);
        double answer = calculator.calculateYield(map, 8000);
        assertThat(answer).isEqualTo(62.5);
    }
    @Test
    void 수익률_소수점_둘째짜리_반올림_테스트() {
        Calculator calculator = new Calculator();
        Map<Rank, Integer> map = new HashMap<>();
        map.put(Rank.FIFTH, 1);
        double answer = calculator.calculateYield(map, 9000);
        assertThat(answer).isEqualTo(55.6);
    }
    @Test
    void 수익률_계산_같은랭크_1개이상_테스트2() {
        Calculator calculator = new Calculator();
        Map<Rank, Integer> map = new HashMap<>();
        map.put(Rank.FIFTH, 2); //10000
        map.put(Rank.FOURTH, 1); // 50000
        double answer = calculator.calculateYield(map, 90000);
        assertThat(answer).isEqualTo(66.7);
    }
}