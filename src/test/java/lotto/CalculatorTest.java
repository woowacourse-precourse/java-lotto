package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @DisplayName("일치 번호와 보너스 번호 유무로 당첨 등수 Enum을 반환한다.")
    @Test
    void getEnum() {
        Calculator calculator = new Calculator();
        Win third = calculator.getWin(5, false);
        assertEquals(Win.THIRD_PLACE, third);
    }

    @Test
    void calculate() {
        Integer ticketNumber = 136;
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(7, 5, 4, 3, 2, 1)));

        new Lotto(List.of(1,2,3,12,9,10), 11);
        Calculator calculator = new Calculator(ticketNumber);
        calculator.calculate(lottos);
        calculator.printStatistic();
    }
}