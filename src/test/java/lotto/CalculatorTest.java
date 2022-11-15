package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}