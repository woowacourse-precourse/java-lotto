package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @DisplayName("로또 구입 금액이 1000원 미만이면 예외가 발생한다.")
    @Test
    void createMoneyByMinimumAmount() {
        assertThatThrownBy(() -> new Money(-300))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 최소 1,000원 이상 구매해야 합니다.");
    }

    @DisplayName("로또 구입 금액이 10만원을 초과하면 예외가 발생한다.")
    @Test
    void createMoneyByMaximumAmount() {
        assertThatThrownBy(() -> new Money(3000000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 한도는 최대 10만원까지입니다.");
    }

    @DisplayName("로또 구입 금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createMoneyByNonUnitAmount() {
        assertThatThrownBy(() -> new Money(5555))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1,000원 단위로 입력해야 합니다.");
    }
}