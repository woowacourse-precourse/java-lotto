package lotto.filter;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusSizeFilterTest {


    @DisplayName("보너스 번호가 지정된 범위의 크기를 벗어날 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenValueIsOutOfSize() {
        assertThatThrownBy(() -> new BonusSizeFilter().doFilter("12"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 지정된 범위 내의 크기일 경우 예외가 발생하지 않는다.")
    @Test
    void successTest() {
        assertThatNoException()
                .isThrownBy(() -> new BonusSizeFilter().doFilter("7"));
    }
}