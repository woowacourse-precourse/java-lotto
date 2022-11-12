package lotto;

import org.junit.jupiter.api.Test;

import static lotto.Application.isVoidInput;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IsVoidInputMethodTest {
    @Test
    void isVoidInput_메소드_예외_테스트() {
        String winningNumberInput = "";
        assertThatThrownBy(() -> isVoidInput(winningNumberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("문자를 입력하십시오.");
    }
}