package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static lotto.Application.isInputCommaAndNumber;

class IsInputCommaAndNumberMethodTest {
    @DisplayName("당첨 번호에 쉼표와 숫자 외 다른 문자를 입력할 경우 예외가 발생한다.")
    @Test
    void IsInputCommaAndNumberMethodExceptionTest1() {
        String numberInput = ".";
        assertThatThrownBy(() -> isInputCommaAndNumber(numberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 쉼표와 숫자 외 다른 문자는 입력이 불가합니다.");
    }

    @DisplayName("당첨 번호에 공백 문자가 포함돼도 예외가 발생한다.")
    @Test
    void IsInputCommaAndNumberMethodExceptionTest2() {
        String numberInput = "1, 3, 5, 6, 11, 13";
        assertThatThrownBy(() -> isInputCommaAndNumber(numberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 쉼표와 숫자 외 다른 문자는 입력이 불가합니다.");
    }

    @DisplayName("당첨 번호에 #과 같은 다른 문자가 포함돼도 예외가 발생한다.")
    @Test
    void IsInputCommaAndNumberMethodExceptionTest3() {
        String numberInput = "#";
        assertThatThrownBy(() -> isInputCommaAndNumber(numberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 쉼표와 숫자 외 다른 문자는 입력이 불가합니다.");
    }

    @DisplayName("숫자와 쉼표만으로 구분된 문자열을 입력 받는다(1).")
    @Test
    void IsInputCommaAndNumberMethodTest1() {
        String numberInput = "1,2,3,4,5,6";
        isInputCommaAndNumber(numberInput);
    }

    @DisplayName("숫자와 쉼표만으로 구분된 문자열을 입력 받는다(2).")
    @Test
    void IsInputCommaAndNumberMethodTest2() {
        String numberInput = "002162,2700251,312056,41923,5566,610923";
        isInputCommaAndNumber(numberInput);
    }

    @DisplayName("숫자와 쉼표만으로 구분된 문자열을 입력 받는다(3).")
    @Test
    void IsInputCommaAndNumberMethodTest3() {
        String numberInput = "00000000000000000000000000000000";
        isInputCommaAndNumber(numberInput);
    }
}