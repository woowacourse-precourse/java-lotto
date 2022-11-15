package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @DisplayName("1000원 보다 작으면 예외가 발생한다")
    @Test
    void createMoneyUnder1000() {
        assertThatThrownBy(() -> new Money(900))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
