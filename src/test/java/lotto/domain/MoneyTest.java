package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @DisplayName("구입 금액이 음수인 경우 예외 발생")
    @Test
    void negativeAmount() {
        int money = -1;
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원 단위가 아닌 경우 예외 발생")
    @Test
    void isNotMultipleOf1000() {
        int money = 999;
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 0원인 경우")
    @Test
    void createMoneyWithZero() {
        int money = 0;
        assertThatCode(() -> new Money(money))
                .doesNotThrowAnyException();
    }
}

