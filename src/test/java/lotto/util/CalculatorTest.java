package lotto.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    
    
    @Test
    void getRateOfReturn1() {
        assertThat(Calculator.getRateOfReturn(10000, 15000)).isEqualTo(150.0);
    }
    
    @Test
    void getRateOfReturn2() {
        assertThat(Calculator.getRateOfReturn(8000, 5000)).isEqualTo(62.5);
    }
    
    @Test
    void getRateOfReturn3() {
        assertThat(Calculator.getRateOfReturn(1000, 3000)).isEqualTo(300.0);
    }
    
    @Test
    void getRateOfReturn5() {
        assertThat(Calculator.getRateOfReturn(1000, 10000000)).isEqualTo(1000000.0);
    }
    
    @DisplayName("수익률은 소수점 둘째 자리에서 반올림 되어야 한다.")
    @Test
    void getRateOfReturn6() {
        assertThat(Calculator.getRateOfReturn(324, 1244)).isEqualTo(384.0);
    }
}
