package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @DisplayName("단위에 벗어난 금액 또는 문자가 들어오면 예외가 발생한다.")
    @Test
    void ValidateMoneyTest() {
        assertThatThrownBy(() -> new Money("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("단위에 벗어난 금액 또는 문자가 들어오면 예외가 발생한다.")
    @Test
    void ValidateMoneyTest2() {
        assertThatThrownBy(() -> new Money("  1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
