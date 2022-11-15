package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.Application.checkRange;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CheckRangeMethodTest {
    private static final String ERROR_MESSAGE = "[ERROR] 번호는 1이상 45이하의 자연수로 구성해야 합니다.";

    @DisplayName("1이상 45이하 자연수를 정상적인 입력으로 받는다.")
    @Test
    void checkRangeMethodTest() {
        for (int number = 1; number <= 45; number++)
            checkRange(number);
    }

    @DisplayName("입력 0: 1이상 45이하 자연수 외 숫자는 예외 처리한다.")
    @Test
    void checkRangeMethodExceptionTest1() {
        assertThatThrownBy(() -> checkRange(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("입력 46: 1이상 45이하 자연수 외 숫자는 예외 처리한다.")
    @Test
    void checkRangeMethodExceptionTest2() {
        assertThatThrownBy(() -> checkRange(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}