package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {
    @DisplayName("구입 금액이 1000으로 나눠 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createAmountNotDivided1000() {
        assertThatThrownBy(() -> new User(14500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}