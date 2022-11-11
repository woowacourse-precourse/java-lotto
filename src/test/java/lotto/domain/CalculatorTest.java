package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @DisplayName("총 수익금을 계산하는 기능 테스트")
    @ParameterizedTest
    @MethodSource("calculateTotalEarningsTestSource")
    void calculateTotalEarningsTest(int totalEarnings, List<Integer> result) throws Exception {
        Calculator calculator = new Calculator();
        Method privateMethod = calculator.getClass().getDeclaredMethod("calculateTotalEarnings", List.class);
        privateMethod.setAccessible(true);

        privateMethod.invoke(calculator, result);

        assertThat(calculator.getTotalEarnings()).isEqualTo(totalEarnings);
    }
    private static Stream<Arguments> calculateTotalEarningsTestSource() {
        return Stream.of(
                Arguments.of(2033150000, List.of(0, 1, 1, 2, 3, 0)),
                Arguments.of(2031555000, List.of(0, 1, 1, 1, 1, 1)),
                Arguments.of(0, List.of(0, 0, 0, 0, 0, 0))
        );
    }
    @DisplayName("수익률 계산 테스트")
    @ParameterizedTest
    @MethodSource("calculateEarningsRateTestSource")
    void calculateEarningsRateTest(List<Integer> result, int purchaseAmount, double earningsRate) throws Exception{
        Calculator calculator = new Calculator();
        Method privateMethod = calculator.getClass().getDeclaredMethod("calculateEarningsRate", int.class);
        privateMethod.setAccessible(true);
        Method setTotalEarnings = calculator.getClass().getDeclaredMethod("calculateTotalEarnings", List.class);
        setTotalEarnings.setAccessible(true);

        setTotalEarnings.invoke(calculator, result);
        privateMethod.invoke(calculator, purchaseAmount);

        assertThat(calculator.getEarningsRate()).isEqualTo(earningsRate);
    }
    private static Stream<Arguments> calculateEarningsRateTestSource() {
        return Stream.of(
                Arguments.of(List.of(0, 1, 1, 2, 3, 0), 9000, 22590555.6),
                Arguments.of(List.of(0, 1, 1, 1, 1, 1), 8000, 25394437.5),
                Arguments.of(List.of(0, 0, 0, 0, 0, 0), 10000, 0)
        );
    }
}
