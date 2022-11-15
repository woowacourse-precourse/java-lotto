package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @DisplayName("구입 금액이 0원 이하일 때 예외가 발생한다.")
    @Test
    void createMoneyByNegative() {
        assertThatThrownBy(() -> new Money(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 0원일 때 예외가 발생한다.")
    @Test
    void createMoneyByZero() {
        assertThatThrownBy(() -> new Money(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000단위가 아닐 때 예외가 발생한다.")
    @Test
    void createMoneyByNotLottoPrice() {
        assertThatThrownBy(() -> new Money(1234))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
