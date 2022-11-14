package lotto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static lotto.Application.isInputCommaAndNumber;

class IsInputCommaAndNumberMethodTest {
    @Test
    void isInputCommaAndNumber_메소드_예외_테스트1() {
        String numberInput = ".";
        assertThatThrownBy(() -> isInputCommaAndNumber(numberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 쉼표와 숫자 외 다른 문자는 입력이 불가합니다.");
    }
    @Test
    void isInputCommaAndNumber_메소드_예외_테스트2() {
        String numberInput = "1, 3, 5, 6, 11, 13";
        assertThatThrownBy(() -> isInputCommaAndNumber(numberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 쉼표와 숫자 외 다른 문자는 입력이 불가합니다.");
    }

    @Test
    void isInputCommaAndNumber_메소드_예외_테스트3() {
        String numberInput = "#";
        assertThatThrownBy(() -> isInputCommaAndNumber(numberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 쉼표와 숫자 외 다른 문자는 입력이 불가합니다.");
    }

    @Test
    void isInputCommaAndNumber_메소드_정상_입력_테스트1() {
        String numberInput = "1,2,3,4,5,6";
        isInputCommaAndNumber(numberInput);
    }

    @Test
    void isInputCommaAndNumber_메소드_정상_입력_테스트2() {
        String numberInput = "002162,2700251,312056,41923,5566,610923";
        isInputCommaAndNumber(numberInput);
    }

    @Test
    void isInputCommaAndNumber_메소드_정상_입력_테스트3() {
        String numberInput = "00000000000000000000000000000000";
        isInputCommaAndNumber(numberInput);
    }
}