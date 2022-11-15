package lotto.filter;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRangeFilterTest {

    @DisplayName("로또 당첨번호가 지정된 범위를 벗어나면 예외가 발생한다.")
    @Test
    void throwExceptionWhenValueIsOutOfRange() {
        assertThatThrownBy(() -> new LottoRangeFilter().doFilter("0,2,3,12,15,42"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("로또 당첨번호가 지정된 범위 내라면 예외가 발생하지 않는다.")
    @Test
    void successTest() {
        assertThatNoException()
                .isThrownBy(() -> new LottoRangeFilter().doFilter("1,2,3,4,5,6"));
    }
}