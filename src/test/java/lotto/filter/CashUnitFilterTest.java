package lotto.filter;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CashUnitFilterTest {

    @DisplayName("입력값이 1000원 단위로 나누어 떨어지지 않을 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenValueNotDivided() {
        assertThatThrownBy(() -> new CashUnitFilter().doFilter("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 0일 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenValueIsZero() {
        assertThatThrownBy(() -> new CashUnitFilter().doFilter("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 1000원 단위일 경우 예외가 발생하지 않는다.")
    @Test
    void successTest() {
        assertThatNoException()
                .isThrownBy(() -> new CashUnitFilter().doFilter("8000"));
    }
}