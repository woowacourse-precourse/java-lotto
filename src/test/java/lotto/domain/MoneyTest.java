package lotto.domain;

import lotto.advice.MoneyException;
import org.junit.jupiter.api.Test;

import static lotto.advice.ErrorMessage.MONEY_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @Test
    void 금액_예외_테스트() {
        assertThatThrownBy(() -> new Money("2350")).isInstanceOf(MoneyException.class).hasMessage(MONEY_ERROR_MESSAGE);
    }
}
