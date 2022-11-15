package lotto.util.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyValidatorTest {
    @DisplayName("구입금액의 예외처리 테스트")
    @Test
    void checkInputMoney() {
        assertThatThrownBy(() -> new MoneyValidator("8001"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new MoneyValidator("800"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new MoneyValidator("-8000"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new MoneyValidator(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new MoneyValidator("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}