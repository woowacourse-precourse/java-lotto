package lotto.domin;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @DisplayName("구입금액이 정수가 아닐때 예외 처리한다.")
    @Test
    void inputValueNotDigit() {
        assertThatThrownBy(() -> new Money("asdf"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 1000으로 나누어 떨어지지 않으면 예외 처리한다.")
    @Test
    void inputPurchaseAmountUndivided() {
        assertThatThrownBy(() -> new Money("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적인 구입금액이면 금액을 보여준다.")
    @Test
    void inputPurchaseAmount() {
        Money money = new Money("2000");
        assertThat(money.getMoney()).isEqualTo(2000);
    }
}
