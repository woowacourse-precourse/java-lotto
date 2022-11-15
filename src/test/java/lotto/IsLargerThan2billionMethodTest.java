package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.Application.isLargerThan2billion;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IsLargerThan2billionMethodTest {
    @DisplayName("20억은 예외가 발생하지 않는다.")
    @Test
    void isLargerThan2billionMethodTest1() {
        Long numberInput = 2_000_000_000L;
        isLargerThan2billion(numberInput);
    }

    @DisplayName("20억보다 큰 경우 예외가 발생한다(1).")
    @Test
    void isLargerThan2billionMethodExceptionTest1() {
        Long numberInput = 2_000_000_001L;
        assertThatThrownBy(() -> isLargerThan2billion(numberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 20억원보다 큰 금액으로 복권을 구매할 수 없습니다.");
    }

    @DisplayName("20억보다 큰 경우 예외가 발생한다(2).")
    @Test
    void isLargerThan2billionMethodExceptionTest2() {
        Long numberInput = 999_999_999_999_999_999L;
        assertThatThrownBy(() -> isLargerThan2billion(numberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 20억원보다 큰 금액으로 복권을 구매할 수 없습니다.");
    }
}