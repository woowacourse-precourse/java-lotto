package lotto;

import lotto.model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    @DisplayName("구입 금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createMoneyByNotDivideThousand() {
        assertThatThrownBy(() -> new Money("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}