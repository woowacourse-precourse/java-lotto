package lotto.filter;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberFilterTest {

    @DisplayName("입력값이 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenValueNotDivided() {
        assertThatThrownBy(() -> new NumberFilter().doFilter("125s2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 없을 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenValueIsZero() {
        assertThatThrownBy(() -> new NumberFilter().doFilter(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 숫자일 경우 예외가 발생하지 않는다.")
    @Test
    void successTest() {
        assertThatNoException()
                .isThrownBy(() -> new NumberFilter().doFilter("8000"));
    }
}