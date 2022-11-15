package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {

    @DisplayName("수익 통계 테스트")
    @Nested
    class getEarningRateTest {

        @Test
        @DisplayName("정상 실행")
        void success1() {
            assertThat(Calculator.getEarningRate(Arrays.asList(0, 0, 0, 0, 1, 0, 0))).isEqualTo("5000.0");
        }

        @Test
        @DisplayName("정상 실행")
        void success2() {
            assertThat(Calculator.getEarningRate(Arrays.asList(0, 0, 0, 0, 0, 1, 2))).isEqualTo("166.7");
        }

        @Test
        @DisplayName("정상 실행")
        void success3() {
            assertThat(Calculator.getEarningRate(Arrays.asList(0, 0, 0, 0, 1, 0, 200))).isEqualTo("24.9");
        }

        @Test
        @DisplayName("정상 실행")
        void success4() {
            assertThat(Calculator.getEarningRate(Arrays.asList(0, 1, 0, 0, 0, 0, 0))).isEqualTo("200000000.0");
        }

        @Test
        @DisplayName("예외 실행: 배열 크기 오류 테스트")
        void fail1() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> Calculator.getEarningRate(Arrays.asList(1, 2, 3, 4, 5, 6)));
        }


    }

}
