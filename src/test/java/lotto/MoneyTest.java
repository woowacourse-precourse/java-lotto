package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    @DisplayName("구입 금액이 1,000원으로 나누어 떨어지지 않을 경우 예외가 발생한다.")
    @Test
    void InputMoneyByWrongNumber() {
        assertThatThrownBy(() -> new Money(11900))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위입니다.");
    }
}
