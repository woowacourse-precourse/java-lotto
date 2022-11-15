package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @DisplayName("구매 금액이 1000원단위가 아닐 경우 예외 발생")
    @Test
    void formatException() {
        assertThatThrownBy(() -> new Money(1234))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void format_amountException_2() {
        assertThatThrownBy(() -> new Money(300))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
