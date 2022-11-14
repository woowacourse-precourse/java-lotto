package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("구입금액에 문자를 입력하면 예외가 발생한다.")
    void createMoneyByNotDigitMoney() {
        assertThatThrownBy(() -> new Money("abcd"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
        assertThatThrownBy(() -> new Money("10j00"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("구입금액에 1,000단위가 아닌 숫자를 입력하면 예외가 발생한다.")
    void createMoneyByNotUnitMoney() {
        assertThatThrownBy(() -> new Money("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
        assertThatThrownBy(() -> new Money("10230"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}