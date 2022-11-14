package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExceptionHandlingTest {

    @DisplayName("1000으로 나누어떨어지지 않으면 IllegalArgumentException을 발생시킴")
    @Test
    void notDivideException() {
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        assertThatThrownBy(() -> exceptionHandling.notDivide(3000000000L))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자인지 검사, 숫자가 아니면 IllegalArgumentException을 발생시킴")
    @Test
    void isNumeric() {
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        assertThatThrownBy(() -> exceptionHandling.isNumeric("123$"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1 ~ 45사이의 숫자인지 검사")
    @Test
    void outRangeLottoNumber() {
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        assertThatThrownBy(() -> exceptionHandling.outRangeLottoNumber("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("리스트 내의 중복 값 검사")
    @Test
    void removeDuplicateNumber() {
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        assertThatThrownBy(() -> exceptionHandling.removeDuplicateNumber(List.of(23, 12, 24, 34, 12, 32)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 보너스 번호가 덩첨 번호에 포함인지 검사")
    @Test
    void containsBonusNumber() {
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        assertThatThrownBy(() -> exceptionHandling.containsBonusNumber(List.of(34, 45, 1, 23, 2, 11), 34))
                .isInstanceOf(IllegalArgumentException.class);
    }
}