package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @DisplayName("돈이 1,000단위로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createMoneyOverUnit() {
        assertThatThrownBy(() -> new Money(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("돈이 음수 이거나 0 이면 예외가 발생한다.")
    @Test
    void createMoneyByOverRange() {
        assertThatThrownBy(() -> new Money(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
