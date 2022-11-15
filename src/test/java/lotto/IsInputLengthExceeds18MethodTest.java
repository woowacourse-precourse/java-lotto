package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.Application.isInputLengthExceeds18;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IsInputLengthExceeds18MethodTest {
    @DisplayName("입력된 번호가 18자리를 넘으면 예외가 발생한다(1).")
    @Test
    void isInputLengthExceeds18MethodExceptionTest1() {
        String numberInput = "3141592653589793238462643383279502884197";
        assertThatThrownBy(() -> isInputLengthExceeds18(numberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 20억원보다 큰 금액으로 복권을 구매할 수 없습니다.");
    }

    @Test
    @DisplayName("입력된 번호가 18자리를 넘으면 예외가 발생한다(2).")
    void isInputLengthExceeds18MethodExceptionTest2() {
        String numberInput = "1234567890123456789";
        assertThatThrownBy(() -> isInputLengthExceeds18(numberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 20억원보다 큰 금액으로 복권을 구매할 수 없습니다.");
    }

    @DisplayName("입력된 번호가 18자리인 경우 예외가 발생하지 않는다.")
    @Test
    void isInputLengthExceeds18MethodTest1() {
        String numberInput = "123456789012345678";
        isInputLengthExceeds18(numberInput);
    }
}