package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @DisplayName("구입금액이 0원이면 예외가 발생한다.")
    @Test
    void createMoneyByZero() {
        assertThatThrownBy(() -> new Money(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 음수이면 예외가 발생한다.")
    @Test
    void createMoneyByNegativeNumber() {
        assertThatThrownBy(() -> new Money(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createMoneyByInvalidUnitNumber() {
        assertThatThrownBy(() -> new Money(2010))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
