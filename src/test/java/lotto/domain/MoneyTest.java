package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.errorenum.Error;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @DisplayName("로또 구입 금액이 최소 금액 (1000원) 이하면 오류가 발생한다")
    @Test
    void createMoneyInputWithLimitError() {
        assertThatThrownBy(() -> new Money(900))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.MIN_MONEY_LIMIT.getCode());
    }

    @DisplayName("로또 구입 금액이 1000원으로 나누어 떨어지지 않는다면 오류가 발생한다")
    @Test
    void createMoneyInputWithChangeLeft() {
        assertThatThrownBy(() -> new Money(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.MONEY_CHANGE_LEFT.getCode());
    }

}
