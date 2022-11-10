package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AmountValidatorTest {

    @Test
    @DisplayName("구입 금액이 음수인 경우 예외 발생")
    void negativeAmount() {
        int amount = -1;
        assertThatThrownBy(() -> AmountValidator.validate(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아닌 경우 예외 발생")
    void isNotMultipleOf1000() {
        int amount = 999;
        assertThatThrownBy(() -> AmountValidator.validate(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
