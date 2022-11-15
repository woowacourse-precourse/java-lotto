package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.Application.isInputLengthExceeds9;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IsInputLengthExceeds9MethodTest {
    private static final String ERROR_MESSAGE = "[ERROR] 번호는 1이상 45이하의 자연수로 구성해야 합니다.";

    @DisplayName("입력된 번호가 9자리를 넘으면 예외가 발생한다(1).")
    @Test
    void isInputLengthExceeds9MethodExceptionTest1() {
        String numberInput = "3141592653589793238462643383279502884197";
        assertThatThrownBy(() -> isInputLengthExceeds9(numberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("입력된 번호가 9자리를 넘으면 예외가 발생한다(2).")
    @Test
    void isInputLengthExceeds9MethodExceptionTest2() {
        String numberInput = "1234567890";
        assertThatThrownBy(() -> isInputLengthExceeds9(numberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("9자리 번호는 예외가 발생하지 않는다.")
    @Test
    void isInputLengthExceeds9MethodTest1() {
        String numberInput = "123456789";
        isInputLengthExceeds9(numberInput);
    }
}