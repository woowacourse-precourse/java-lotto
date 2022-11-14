package lotto;

import org.junit.jupiter.api.Test;

import static lotto.Application.isInputLengthExceeds18;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IsInputLengthExceeds18MethodTest {
    @Test
    void isInputLengthExceeds18_메소드_예외_테스트1() {
        String numberInput = "3141592653589793238462643383279502884197";
        assertThatThrownBy(() -> isInputLengthExceeds18(numberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 20억원보다 큰 금액으로 복권을 구매할 수 없습니다.");
    }

    @Test
    void isInputLengthExceeds18_메소드_예외_테스트2() {
        String numberInput = "1234567890123456789";
        assertThatThrownBy(() -> isInputLengthExceeds18(numberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 20억원보다 큰 금액으로 복권을 구매할 수 없습니다.");
    }

    @Test
    void isInputLengthExceeds18_메소드_정상_입력_테스트1() {
        String numberInput = "123456789012345678";
        isInputLengthExceeds18(numberInput);
    }
}