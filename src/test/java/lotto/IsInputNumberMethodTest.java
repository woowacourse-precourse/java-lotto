package lotto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static lotto.Application.isInputNumber;

class IsInputNumberMethodTest {
    @Test
    void IsInputNumber_메소드_예외_테스트1() {
        String numberInput = ".";
        assertThatThrownBy(() -> isInputNumber(numberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자 외 다른 문자는 입력이 불가합니다.");
    }

    @Test
    void IsInputNumber_메소드_예외_테스트2() {
        String numberInput = "-45";
        assertThatThrownBy(() -> isInputNumber(numberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자 외 다른 문자는 입력이 불가합니다.");
    }

    @Test
    void IsInputNumber_메소드_예외_테스트3() {
        String numberInput = "neppiness";
        assertThatThrownBy(() -> isInputNumber(numberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자 외 다른 문자는 입력이 불가합니다.");
    }

    @Test
    void IsInputNumber_메소드_정상_입력_테스트1() {
        String numberInput = "92233720368547758086516547651651651";
        isInputNumber(numberInput);
    }

    @Test
    void IsInputNumber_메소드_정상_입력_테스트2() {
        String numberInput = "007";
        isInputNumber(numberInput);
    }

    @Test
    void IsInputNumber_메소드_정상_입력_테스트3() {
        String numberInput = "0";
        isInputNumber(numberInput);
    }
}