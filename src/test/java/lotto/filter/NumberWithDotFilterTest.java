package lotto.filter;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberWithDotFilterTest {

    @DisplayName("입력값이 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenValueNotNumber() {
        assertThatThrownBy(() -> new NumberWithDotFilter().doFilter("1,2,5,s,2,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 없을 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenValueIsEmpty() {
        assertThatThrownBy(() -> new NumberWithDotFilter().doFilter(""))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("입력값이 지정된 크기보다 크다면 예외가 발생한다.")
    @Test
    void throwExceptionWhenValueIsBiggerThanOriginSize() {
        assertThatThrownBy(() -> new NumberWithDotFilter().doFilter("1,2,3,12,15,42,45"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 지정된 크기보다 작다면 예외가 발생한다.")
    @Test
    void throwExceptionWhenValueIsSmallerThanOriginSize() {
        assertThatThrownBy(() -> new NumberWithDotFilter().doFilter("1,2,3,12,15"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("입력값이 지정된 크기 내의 쉼표로 구분된 숫자라면 예외가 발생하지 않는다.")
    @Test
    void successTest() {
        assertThatNoException()
                .isThrownBy(() -> new NumberWithDotFilter().doFilter("1,2,3,4,5,6"));
    }

    @DisplayName("입력값이 지정된 크기 내의 쉼표로 구분된 공백을 포함한 숫자라면 예외가 발생한다.")
    @Test
    void successTestWithSpace() {
        assertThatThrownBy(() -> new NumberWithDotFilter().doFilter("1   ,   2,3,   4    ,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}