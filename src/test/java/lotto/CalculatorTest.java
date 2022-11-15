package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @DisplayName("발행 로또와 당첨 로또가 매칭이 보너스 포함 3개가 된다.")
    @Test
    void 매칭3개보너스포함() {
        List<Integer> results = List.of(1,2,3,4,5);
        int money = 1_000_000_000;
        assertEquals(calculator.getProfitRate(results, money), 1012.4605);
    }
}