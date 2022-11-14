package lotto.filter;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberFilterTest {

    @DisplayName("입력값이 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenValueNotNumber() {
        assertThatThrownBy(() -> new NumberFilter().doFilter("125s2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 없을 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenValueIsEmpty() {
        assertThatThrownBy(() -> new NumberFilter().doFilter(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("공백만 입력되었을 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenValueIsSpace() {
        assertThatThrownBy(() -> new NumberFilter().doFilter("           "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 천원 단위의 숫자일 경우 예외가 발생하지 않는다.")
    @Test
    void successTest() {
        assertThatNoException()
                .isThrownBy(() -> new NumberFilter().doFilter("8000"));
    }

    @DisplayName("입력값이 공백을 포함한 천원 단위의 숫자일 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenValueIsMixedWithSpace() {
        assertThatThrownBy(() -> new NumberFilter().doFilter("8  0   0  0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}