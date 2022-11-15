package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @DisplayName("로또 구입 금액이 1,000원 단위가 아니라면 예외가 발생한다.")
    @Test
    void 구입금액_1000원단위_테스트() {
        assertThatThrownBy(() -> new Money(2005))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
