package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTest {
    @DisplayName("구입 금액이 1,000원으로 나누어 떨어지지 않을 경우 예외가 발생한다.")
    @Test
    void InputMoneyByWrongNumber() {
        assertThatThrownBy(() -> new Money(11900))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위입니다.");
    }

    @DisplayName("구입 금액을 1,000원으로 나누어 발행할 로또의 개수를 반환한다.")
    @Test
    void getNumberToPublishLottos() {
        Money money = new Money(8000);
        assertEquals(8, money.getNumberToPublishLottos());
    }

    @DisplayName("수익률을 반환한다.")
    @Test
    void calculateYield() {
        Money money = new Money(8000);
        assertThat(money.calculateYield(5000)).isEqualTo("62.5");
    }
}
