package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.utils.ErrorMessages.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"!000", "1000A"})
    void createMoneyByNotInteger(String money) {
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MONEY_NOT_INTEGER);
    }
}
