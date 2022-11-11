package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    @DisplayName("구입 금액이 음수인 경우 예외 발생")
    void negativeAmount() {
        int money = -1;
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아닌 경우 예외 발생")
    void isNotMultipleOf1000() {
        int money = 999;
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

