package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidUtilTest {

    @Test
    @DisplayName("로또 구입 금액으로 숫자를 입력하지 않으면 오류가 발생한다.")
    void validInputAmounts() {
        assertThatThrownBy(() -> ValidUtil.validInputAmounts("1s00"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구입 금액으로 1000원 단위에 금액를 입력하지 않으면 오류가 발생한다.")
    void validAmountUnit() {
        assertThatThrownBy(() -> ValidUtil.validAmountUnit(1010))
                .isInstanceOf(IllegalArgumentException.class);

    }
}