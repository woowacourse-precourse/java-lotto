package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    @DisplayName("1000 단위로 나누어 떨어지지 않는 경우 (거스름돈이 생기는 경우)")
    @Test
    void createMoneyByHavingMoney() {
        assertThatThrownBy(() -> new Money(Integer.parseInt("123456")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또를 살 수 없는 경우 (1000 이하의 수가 입력된 경우)")
    @Test
    void createMoneyByCannotBuyLotto() {
        assertThatThrownBy(() -> new Money(Integer.parseInt("0")))
                .isInstanceOf(IllegalArgumentException.class);
    }

}