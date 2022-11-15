package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @DisplayName("계산기는 수익율을 구한다.")
    @Test
    void 수익률_구하기() {
        List<Integer> results = List.of(1,2,3,4,5);
        int money = 1_000_000_000;
        assertEquals(calculator.getProfitRate(results, money), 1012.4605);
    }

    @DisplayName("결과값은 5개의 원소로 이루어져야한다.")
    @Test
    void 결과값_5개원소() {
        List<Integer> results = List.of(1,2,3,4);
        int money = 1_000_000_000;
        assertThatThrownBy(() -> calculator.getProfitRate(results, money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}