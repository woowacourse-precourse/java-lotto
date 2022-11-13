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
        @DisplayName("정상 실행 테스트 1")
        void successTest1() {
            assertThat(Calculator.getEarningRate(Arrays.asList(0, 0, 1, 0, 0, 0))).isEqualTo(5000.0);
        }

        @Test
        @DisplayName("배열 크기 오류 테스트")
        void arraySizeErrorTest() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> Calculator.getEarningRate(Arrays.asList(1, 2, 3, 4, 5)));
        }
    }


}
