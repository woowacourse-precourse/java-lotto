package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.Application.isDividedBy1000;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IsDividedBy1000MethodTest {
    @DisplayName("입력 금액이 1인 경우 예외가 발생한다.")
    @Test
    void isDividedBy1000MethodExceptionTest1() {
        Long numberInput = 1L;
        assertThatThrownBy(() -> isDividedBy1000(numberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액을 1000원 단위로 입력해 주세요.");
    }

    @DisplayName("입력 금액이 9인 경우 예외가 발생한다.")
    @Test
    void isDividedBy1000MethodExceptionTest2() {
        Long numberInput = 9L;
        assertThatThrownBy(() -> isDividedBy1000(numberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액을 1000원 단위로 입력해 주세요.");
    }

    @DisplayName("입력 금액 20억은 예외가 발생하지 않는다.")
    @Test
    void isDividedBy1000MethodTest1() {
        Long numberInput = 2_000_000_000L;
        isDividedBy1000(numberInput);
    }

    @DisplayName("입력 금액 0은 예외가 발생하지 않는다.")
    @Test
    void isDividedBy1000MethodTest2() {
        Long numberInput = 0L;
        isDividedBy1000(numberInput);
    }
}