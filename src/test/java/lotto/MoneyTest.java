package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    @Test
    @DisplayName("로또 구입 금액이 최소 구입 금액 이하이면 예외를 발생시킨다.")
    void createLottoMoneyUnderMinimumValue() {
        assertThatThrownBy(() -> new Money(-1200))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구입 금액이 1,000원 단위가 아니라면 예외를 발생시킨다.")
    void createLottoMoneyUnitIsNot1000() {
        assertThatThrownBy(() -> new Money(5200))
                .isInstanceOf(IllegalArgumentException.class);
    }
}