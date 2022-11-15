package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static lotto.Application.isInputNumber;

class IsInputNumberMethodTest {
    @DisplayName("숫자 외 다른 문자에 대해 예외가 발생한다(1).")
    @Test
    void isInputNumberMethodExceptionTest1() {
        String numberInput = ".";
        assertThatThrownBy(() -> isInputNumber(numberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자 외 다른 문자는 입력이 불가합니다.");
    }

    @DisplayName("숫자 외 다른 문자에 대해 예외가 발생한다(2).")
    @Test
    void isInputNumberMethodExceptionTest2() {
        String numberInput = "-45";
        assertThatThrownBy(() -> isInputNumber(numberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자 외 다른 문자는 입력이 불가합니다.");
    }

    @DisplayName("영문자 또한 예외가 발생한다.")
    @Test
    void isInputNumberMethodExceptionTest3() {
        String numberInput = "Neppiness";
        assertThatThrownBy(() -> isInputNumber(numberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자 외 다른 문자는 입력이 불가합니다.");
    }

    @DisplayName("숫자로만 구성된 긴 문자열은 예외가 발생하지 않는다.")
    @Test
    void isInputNumberMethodTest1() {
        String numberInput = "92233720368547758086516547651651651";
        isInputNumber(numberInput);
    }

    @DisplayName("0으로 시작하는 숫자도 예외가 발생하지 않는다.")
    @Test
    void isInputNumberMethodTest2() {
        String numberInput = "007";
        isInputNumber(numberInput);
    }

    @DisplayName("0은 예외가 발생하지 않는다.")
    @Test
    void isInputNumberMethodTest3() {
        String numberInput = "0";
        isInputNumber(numberInput);
    }
}