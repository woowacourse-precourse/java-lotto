package lotto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static lotto.Application.isCommaAndNumber;

class IsCommaAndNumberMethodTest {
    @Test
    void isCommaAndNumber_메소드_예외_테스트1() {
        String winningNumberInput = ".";
        assertThatThrownBy(() -> isCommaAndNumber(winningNumberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("쉼표와 숫자 외 다른 문자는 입력이 불가합니다.");
    }
    @Test
    void isCommaAndNumber_메소드_예외_테스트2() {
        String winningNumberInput = "1, 3, 5, 6, 11, 13";
        assertThatThrownBy(() -> isCommaAndNumber(winningNumberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("쉼표와 숫자 외 다른 문자는 입력이 불가합니다.");
    }

    @Test
    void isCommaAndNumber_메소드_예외_테스트3() {
        String winningNumberInput = "#";
        assertThatThrownBy(() -> isCommaAndNumber(winningNumberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("쉼표와 숫자 외 다른 문자는 입력이 불가합니다.");
    }

    @Test
    void isCommaAndNumber_메소드_정상_입력_테스트1() {
        String winningNumberInput = "1,2,3,4,5,6";
        isCommaAndNumber(winningNumberInput);
    }

    @Test
    void isCommaAndNumber_메소드_정상_입력_테스트2() {
        String winningNumberInput = "002162,2700251,312056,41923,5566,610923";
        isCommaAndNumber(winningNumberInput);
    }

    @Test
    void isCommaAndNumber_메소드_정상_입력_테스트3() {
        String winningNumberInput = ",";
        isCommaAndNumber(winningNumberInput);
    }
}