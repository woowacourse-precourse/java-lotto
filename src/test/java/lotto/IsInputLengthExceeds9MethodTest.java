package lotto;

import org.junit.jupiter.api.Test;

import static lotto.Application.isInputLengthExceeds9;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IsInputLengthExceeds9MethodTest {
    private static final String ERROR_MESSAGE = "[ERROR] 번호는 1이상 45이하의 자연수로 구성해야 합니다.";

    @Test
    void isInputLengthExceeds9_메소드_예외_테스트1() {
        String numberInput = "3141592653589793238462643383279502884197";
        assertThatThrownBy(() -> isInputLengthExceeds9(numberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void isInputLengthExceeds9_메소드_예외_테스트2() {
        String numberInput = "1234567890";
        assertThatThrownBy(() -> isInputLengthExceeds9(numberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void isInputLengthExceeds9_메소드_정상_입력_테스트1() {
        String numberInput = "123456789";
        isInputLengthExceeds9(numberInput);
    }
}