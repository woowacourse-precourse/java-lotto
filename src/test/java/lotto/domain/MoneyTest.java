package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @DisplayName("1000원 단위가 아닌 금액은 예외가 발생한다.")
    @Test
    void createMoneyWithUnmatchingUnit() {
        assertThatThrownBy(() -> new Money(2300))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
