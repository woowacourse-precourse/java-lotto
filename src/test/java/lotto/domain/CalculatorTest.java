package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
    private static final List<Integer> winningNumber = Arrays.asList(3, 0, 0, 0, 0, 0);
    private Calculator calculator;

    @BeforeEach
    void SetUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource({"7,0,1,2,3,0,30005000", "6,7,1,2,0,0,2030000000", "1,2,1,2,0,1,0", "3,3,4,3,2,1,65000"})
    public void sumJackPot(int num1, int num2, int num3, int num4, int num5, int num6, int expected) {
        int actual = calculator.sumJackpot(Arrays.asList(num1, num2, num3, num4, num5, num6));
        assertThat(actual).isEqualTo(expected);
    }

}
