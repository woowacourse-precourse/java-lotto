package lotto.filter;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoDuplicationFilterTest {

    @DisplayName("중복되는 로또 당첨번호가 존재하면 예외가 발생한다.")
    @Test
    void throwExceptionWhenValueIsDuplicated() {
        assertThatThrownBy(() -> new LottoDuplicationFilter().doFilter("1,2,3,1,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("중복되는 로또 당첨번호가 존재하지 않는다면 예외가 발생하지 않는다.")
    @Test
    void successTest() {
        assertThatNoException()
                .isThrownBy(() -> new LottoDuplicationFilter().doFilter("1,2,3,4,5,6"));
    }
}