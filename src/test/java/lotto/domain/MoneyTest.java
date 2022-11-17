package lotto.domain;

import lotto.utils.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    @DisplayName("구입 금액은 1,000원 단위로 나누어 떨어져야 한다.")
    @Test
    void createLottosWithIndivisibleMoney() {
        assertThatThrownBy(() -> Money.of(5_100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.MONEY_LEFT_OVER);
    }
}