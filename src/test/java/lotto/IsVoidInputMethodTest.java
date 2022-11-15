package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.Application.isVoidInput;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IsVoidInputMethodTest {
    @DisplayName("아무런 입력도 없는 경우에 대해 예외가 발생한다.")
    @Test
    void isVoidInputMethodExceptionTest() {
        String winningNumberInput = "";
        assertThatThrownBy(() -> isVoidInput(winningNumberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 문자를 입력하십시오.");
    }
}