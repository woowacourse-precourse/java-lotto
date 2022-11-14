package lotto.domain.validutils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberValidUtilsTest {

    @DisplayName("숫자가 0이면 예외 발생")
    @Test
    void validateMinimumValue() {
        assertThatThrownBy(() -> LottoNumberValidUtils.validateRange(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1~45 사이의 숫자 이어야 합니다.");
    }

    @DisplayName("숫자가 46이면 예외 발생")
    @Test
    void validateMaximumValue() {
        assertThatThrownBy(() -> LottoNumberValidUtils.validateRange(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1~45 사이의 숫자 이어야 합니다.");
    }
}