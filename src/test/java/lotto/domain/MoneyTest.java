package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void checkBuyMoneyIsNotNumeric() {
        assertThatThrownBy(() -> new Money("100d0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000보다 작으면 예외가 발생한다.")
    @Test
    void checkBuyMoneyLess() {
        assertThatThrownBy(() -> new Money("900"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000으로 나누어지지 않으면 예외가 발생한다.")
    @Test
    void checkBuyMoneyDivide() {
        assertThatThrownBy(() -> new Money("1300"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
